package StudyInternetSocket;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static StudyInternetSocket.SimpleServer.BYE;
import static StudyInternetSocket.SimpleServer.SERVER_CHARSET;

public class Chat {
    private String from;  // 消息来源
    private String greetings; // 问候语句
    private Socket socket; // 套接字

    // 有参构造方法
    public Chat(String from,String greetings,Socket socket){
        this.from = from;
        this.greetings = greetings;
        this.socket = socket;
    }

    // 聊天执行
    public void chatting() throws IOException {
        Scanner in = new Scanner(System.in);
        try(
                // 建立输入输出
                BufferedReader bu = new BufferedReader(new InputStreamReader(socket.getInputStream(),SERVER_CHARSET));
                PrintWriter pr = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),SERVER_CHARSET));
                ){
            System.out.println("Socket连接成功！输入输出已开启");
            if(greetings != null){
                pr.println("你好 " + from + "," + greetings);
                pr.flush();
            }
            while(true){
                String line = bu.readLine(); // 读取对方输入的一行
                if(line.trim().equalsIgnoreCase(BYE)){
                    System.out.println("对方要求断开连接");
                    pr.println(BYE);
                    pr.flush();
                    break;
                } else {
                    System.out.println("来自\"" + from + "\"的消息：" + line);
                }
                // 继续输入
                line = in.nextLine();
                pr.println(line); // 输出给对方
                pr.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("聊天结束");
    }
}
