package StudyInternetSocket.studyWrite;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static StudyInternetSocket.studyWrite.ServerDemo.*;

/**
 * 我是客户端
 */
public class ClientDemo {
    public static void main(String[] args) {
        comWithServer();
    }

    // 与服务端进行连接，并进行交流
    private static void comWithServer() {
        Scanner s = new Scanner(System.in);
        try(
                // 本地客户端连接服务端口
                Socket socket = new Socket("localhost",MY_SERVER_PORT);
                ){
            ChatDemo chat = new ChatDemo("服务端",null,socket);
            chat.chatting();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
}
