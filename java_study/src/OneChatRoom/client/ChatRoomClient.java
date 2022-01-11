package OneChatRoom.client;

import OneChatRoom.common.ChatMessage;
import OneChatRoom.common.DataExchange;
import OneChatRoom.common.Utils;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static OneChatRoom.common.Constants.*;

/**
 * 客户端逻辑描述
 */
public class ChatRoomClient {
    private String server;
    DataExchange exchange;
    private String userName;
    private String currentToName; // 保存检验后的用户名
    private Scanner input = new Scanner(System.in);

    /**
     * 构造方法，客户端连接服务器
     * @param server  服务端信息
     * @throws IOException
     */
    public ChatRoomClient(String server) throws IOException {
        System.out.println("客户端连接中... ...");
        this.server = server;
        Socket socket = new Socket(server,SERVER_PORT);
        System.out.println("客户端已连接到服务器：" + socket.getRemoteSocketAddress()); // 获取服务端连接地址
        exchange = new DataExchange(socket); // 初始化数据交换对象
    }

    /**
     *
     * @throws IOException
     */
    public void start() throws IOException {
        initName();  // 初始化用户名

        // 创建两个线程执行程序
        /**
         * 读（接收）消息执行线程
         */
        Thread readThread = new Thread(() ->{
            while(true){
                try{
                    ChatMessage chatMessage = exchange.receive();
                    // 判断发消息的时admin，且消息内容为"bye"
                    if(chatMessage.getFrom().equalsIgnoreCase(ADMIN_NAME)
                            && chatMessage.getMessage().trim().equalsIgnoreCase(BYE)){
                        exchange.close(); // 关闭资源
                        System.out.println("已经离开聊天室，程序结束");
                        System.exit(0); // 正常终止
                    }
                    // 打印出接收到的消息内容
                    System.out.println("from \"" + chatMessage.getFrom() + "\" 的消息:" + chatMessage.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    exchange.close();
                    System.exit(-2); // 异常终止
                }
            }
        });
        readThread.start(); // 开始执行线程

        /**
         * 写（发送）消息执行线程
         */
        Thread writeThread = new Thread(() ->{
            while(true){
                try{
                    exchange.send(createChatMessage()); // 转发一条聊天消息
                } catch (Exception e) {
                    e.printStackTrace();
                    exchange.close();
                    System.exit(-3);
                }
            }
        });
        writeThread.start(); // 开始执行线程
    }

    /**
     *对输入的内容进行检查处理
     * @return 消息描述对象
     */
    private ChatMessage createChatMessage() {
        while (true) {
            String line = input.nextLine().trim(); // 键盘输入内容
            String to = null;
            String message = null;
            try {
                // 判断输入的内容是以指定"@"字符开头的
                if (line.startsWith(CHAT_WITH_START)) {
                    to = line.substring(1, line.indexOf(SPACE_STRING)).trim(); // 获取索引范围为1, line.indexOf(SPACE_STRING)的字符串
                    String error = Utils.isValidUserName(to); // 检查用户名
                    // 用户名检查通过时
                    if (error == null) {
                        currentToName = to;
                        message = line.substring(line.indexOf(SPACE_STRING) + 1); // 保存解析的消息内容
                    } else {
                        System.out.println("用户名\"" + to + "\"不合法：" + error);
                        continue;
                    }
                } else {
                    if (currentToName == null) {
                        System.out.println("请使用@输入想和谁聊天，以后如果和同一个人聊天，就不用@了");
                        continue;
                    }
                    message = line;
                }
            } catch (Exception e) {
                System.out.println("输入的消息不对：" + line); // 输出异常
                continue;
            }
            return new ChatMessage(userName,currentToName,message);  // 返回消息描述度对象
        }
    }

    /**
     * 初始化用户名，确保返回有效用户名
     * @throws IOException
     */
    private void initName() throws IOException {
        String typeName = null;
        while(true){
            ChatMessage chatMessage = exchange.receive(); // 接收服务端发过来的消息
            String serverMessage = chatMessage.getMessage();
            // 判断用户名检查通过（消息内容=="UserNamePass"表示验证通过），赋值有效名称
            if(serverMessage.equalsIgnoreCase(USER_NAME_PASS)){
                userName = typeName;
                break;
            } else{
                System.out.println(serverMessage);
                typeName = input.nextLine(); // 继续输入
                exchange.send(new ChatMessage(NO_NAME,ADMIN_NAME,typeName.trim()));  // 将输入的消息转发给服务端
            }
        }
    }
}
