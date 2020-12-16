package StudyInternetSocket.studyWrite;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *  我是服务端
 */
public class ServerDemo {

    public static final int MY_SERVER_PORT = 54321;
    public static final Charset MY_CHARSET = StandardCharsets.UTF_8;  //给定一个字符编码
    public static final String MY_BYE = "bye";  // 定义一个关键字

    public static void main(String[] args) {

        comWithClient();
    }

    // 创建服务器，与客户端进行交互
    private static void comWithClient() {
        // 初始化输入语句
        Scanner scanner = new Scanner(System.in);
        System.out.println("服务器启动，在端口" + MY_SERVER_PORT + "处监听... ...");
        try(
                ServerSocket s = new ServerSocket(MY_SERVER_PORT);
                Socket ss = s.accept();  // 会等待接收连接
                ){
            ChatDemo chatDemo = new ChatDemo("客户端","你已连接成功，我们开始对话吧",ss);
            chatDemo.chatting();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
}
