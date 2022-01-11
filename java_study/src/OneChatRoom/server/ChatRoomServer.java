package OneChatRoom.server;

import OneChatRoom.common.ChatMessage;
import OneChatRoom.common.DataExchange;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static OneChatRoom.common.Constants.*;
import static OneChatRoom.common.Utils.isValidUserName;

/**
 * 服务端逻辑描述
 * 1、获取用户名
 * 2、处理发给admin的消息指令
 * 3、处理转发的消息
 */
public class ChatRoomServer {
    private int port;
    private Map<String, DataExchange> name2DataExchange = new ConcurrentHashMap<>(); // map保存用户名和数据转换类的映射关系
    private ExecutorService service = Executors.newCachedThreadPool(); // 创建线程池

    public ChatRoomServer(int port){
        this.port = port;
    }

    /**
     * 开启服务server
     * @throws IOException
     */
    public void start() throws IOException {
        System.out.println("服务器已启动");
        ServerSocket ss = new ServerSocket(SERVER_PORT); // 开启服务监听端口
        while(true){
            Socket socket = ss.accept(); // 监听捕获socket客户端连接
            handleClientSocket(socket);
        }
    }

    /**
     * 提交给一个线程执行，遵循一个线程服务一个连接
     * @param socket 监听到客户端的socket连接
     */
    private void handleClientSocket(Socket socket) {
        service.submit(new ClientHandler(socket)); // 扔给一个新的线程去执行
    }

    /**
     * 内部类 ，实现Runnable接口
     */
    class ClientHandler implements Runnable {
        private Socket socket;
        private String userName = null;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("处理来自" + socket.getRemoteSocketAddress() + "的连接");
            DataExchange dataExchange = null;
            try{
                dataExchange = new DataExchange(socket); // 实例化数据交换对象，并且初始化读写流
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            
            initUser(dataExchange); // 获取一个用户名

            while(true){
                try{
                    ChatMessage chatMessage = dataExchange.receive(); // 接收消息
                    String toName = chatMessage.getTo(); // 获取 to 信息
                    // 判断是否toName == admin 时，即转发消息给admin的
                    if(toName.equalsIgnoreCase(ADMIN_NAME)){
                        handleServerCommand(chatMessage);
                    } else{
                        handleChatMessage(dataExchange,chatMessage,toName);  // 消息转发给指定接收者
                    }
                } catch (IOException e) {
                    name2DataExchange.remove(userName).close(); // 抛出移除映射键值对
                    e.printStackTrace();
                    return;
                }
            }
        }

        /**
         *  消息转发给指定接收者
         * @param dataExchange 数据交换对象
         * @param chatMessage 聊天消息描述对象
         * @param toName to的用户名，即接收消息的人
         */
        private void handleChatMessage(DataExchange dataExchange, ChatMessage chatMessage, String toName) {
            DataExchange toEx = name2DataExchange.get(toName); // 获取toName 的映射数据交换对象
            // 判断要转发的用户名不存在时
            if(toEx == null){
                dataExchange.send(new ChatMessage(ADMIN_NAME,chatMessage.getFrom(),"用户名\"" + toName +"\"不存在")); // 给发消息的人返回提示
            }else{
                toEx.send(chatMessage); // 转发消息给接收者
            }
        }

        /**
         * 接收特殊指令时，服务端处理逻辑
         * @param chatMessage 聊天描述对象
         */
        private void handleServerCommand(ChatMessage chatMessage) {
            DataExchange from = name2DataExchange.get(chatMessage.getFrom()); // 获取该用户的数据交换对象映射
            String command = chatMessage.getMessage(); // 获取消息内容

            // 判断如果接收到客户端的消息内容是指令 "logoff" 时，回复"bye"，如果是指令"list"，则回复所有用户
            if(command.equalsIgnoreCase(SERVER_COMMAND_LOGOFF)){
                from.send(new ChatMessage(ADMIN_NAME,chatMessage.getFrom(),BYE)); //给客户端回复 "bye"
                from.close();
                System.out.println("用户\"" + chatMessage.getFrom() + "\"离开聊天室");
            } else if(command.equalsIgnoreCase(SERVER_COMMAND_LIST)){
                String allNames = getAllNames(); // 获取所有用户名
                from.send(new ChatMessage(ADMIN_NAME,chatMessage.getFrom(),"所有在线用户：" + allNames));
            }
        }

        /**
         * 获的一个用户名
         * @param dataExchange
         */
        private void initUser(DataExchange dataExchange) {
            String errorMsg = null;  //保存错误信息
            while(true){
                String allNames = getAllNames(); //获取所有用户名信息
                // 发送消息给客户端
                dataExchange.send(new ChatMessage(ADMIN_NAME,NO_NAME,
                        (errorMsg == null ? "" : "用户名非法，错误信息为：" + errorMsg + ":") + "现有的用户有："
                + allNames + "。请输入你的用户名："));

                try{
                    // 解析从客户端发过来的消息（用户名）
                    ChatMessage chatMessage = dataExchange.receive(); // 接收消息
                    String userName = chatMessage.getMessage(); // 获取用户名
                    errorMsg = isValidUserName(userName); // 检查用户名合法性，保存检查结果
                    if(errorMsg == null && (!name2DataExchange.containsKey(userName))){
                        this.userName = userName;
                        name2DataExchange.put(userName,dataExchange); // 存储用户名和 数据交换对象映射
                        dataExchange.send(new ChatMessage(ADMIN_NAME,userName,USER_NAME_PASS)); // 作为用户名验证通过消息，不做打印输出
                        dataExchange.send(new ChatMessage(ADMIN_NAME,userName,COMMAND_INTRODUCTION));
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    dataExchange.close(); // 关闭读写流，释放资源
                    return;
                }
            }
        }

        /**
         * 获取所有连接到该服务器的 用户名信息
         * @return
         */
        private String getAllNames() {
            String userNameListSep = ", ";  // 表示分隔符
            // 返回map中映射的用户名
            if(name2DataExchange.isEmpty()){
                return CHAT_WITH_START + ADMIN_NAME;
            } else {
                return CHAT_WITH_START + ADMIN_NAME + userNameListSep + CHAT_WITH_START
                        + String.join(userNameListSep+CHAT_WITH_START,name2DataExchange.keySet()); // 返回所以的用户名，按userNameListSep+CHAT_WITH_START分隔排列
            }
        }
    }
}
