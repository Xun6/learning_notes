package StudyInternetSocket.studyWrite;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static StudyInternetSocket.studyWrite.ServerDemo.MY_BYE;
import static StudyInternetSocket.studyWrite.ServerDemo.MY_CHARSET;

// 交流逻辑封装
public class ChatDemo {
    private static String from;  // 代表对方
    private static String greeting;   // 问候语
    private static Socket socket;

   // 构造方法
    public ChatDemo(String from, String greeting, Socket socket) {
        this.from = from;
        this.greeting = greeting;
        this.socket = socket;
    }

    public void chatting(){
        Scanner scanner = new Scanner(System.in);
        try(
                // 输入输出流
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),MY_CHARSET));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),MY_CHARSET));
                ){
            System.out.println("socket连接成功，请开始交流！");
            if(greeting != null){
                writer.println(from + "," + greeting);
                writer.flush();
            }
            while(true){
                String line = reader.readLine();
                if(line.trim().equalsIgnoreCase(MY_BYE)){
                    System.out.println("对方要断开连接");
                    writer.println(line);
                    writer.flush();
                    break;
                } else {
                    System.out.println("来自" + from + "的信息：" + line);
                }
                // 继续输入
                line = scanner.nextLine();
                writer.println(line);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("聊天结束");
    }
}
