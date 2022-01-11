package OneChatRoom.common;

import java.io.*;
import java.net.Socket;

import static OneChatRoom.common.Constants.DEFAULT_CHARSET;

/**
 * 数据交换逻辑
 * （消息转发逻辑，即所有发送消息经服务器转发给双方）
 */
public class DataExchange {
    private Socket socket; //初始化 socket连接引用
    private BufferedReader reader; // 初始化 读数据引用
    private PrintWriter writer; // 初始化 写数据引用
    private boolean isClosed = false; // 是否关闭流，默认否

    /**
     * 带参数构造方法
     * @param socket  传入一个 socket 对象
     * @throws IOException
     */
    public DataExchange(Socket socket) throws IOException {
        this.socket = socket;
        init(socket); // 初始化 读/写对象
    }

    /**
     * 初始化 读/写对象
     * @param socket
     * @throws IOException
     */
    private void init(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),DEFAULT_CHARSET));
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),DEFAULT_CHARSET));
    }

    /**
     * 发送消息
     * @param chatMessage 消息对象
     */
    public void send(ChatMessage chatMessage){
        writer.println(chatMessage.toMessageString()); // 输出流打印拼接后的消息
        writer.flush(); // 刷新写入流/缓冲区，立即写入
    }

    /**
     * 接收消息
     * @return 返回分割后的消息内容
     * @throws IOException
     */
    public ChatMessage receive() throws IOException {
        String line = null;
        while(true){
            line = reader.readLine(); // 读取一行文本，直到出现换行符 或结束符
            // 判断是否收到有效的一行文本信息
            if(line !=null && line.length() >0){
                break;
            }
        }
        return ChatMessage.buildFrom(line);
    }

    // 关闭流
    public void close(){
        try{
            reader.close(); // 关闭读取流
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            writer.close(); // 关闭写出流
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            socket.close(); // 关闭 socket
        } catch (IOException e) {
            e.printStackTrace();
        }
        isClosed = true; // 确认全部关闭
    }
}
