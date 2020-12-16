package StudyInternetSocket;

import java.io.IOException;
import java.net.Socket;

import static StudyInternetSocket.SimpleServer.SERVER_PORT;

/**
 * 客户端
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException {
        commWithServer();
    }

    // 开启与服务器端对话
    private static void commWithServer() throws IOException {
        try(
                // 在本机（127.0.0.1）建立与服务器端的连接
                Socket s = new Socket("localhost",SERVER_PORT);
                ){
            Chat chat = new Chat("服务端",null,s);
            chat.chatting();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("程序退出！");
    }
}
