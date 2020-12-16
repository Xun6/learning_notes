package StudyInternetSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 服务器端
 */
public class SimpleServer {

    public static final int SERVER_PORT = 45632;  // 服务器端口
    public static final Charset SERVER_CHARSET = StandardCharsets.UTF_8;  // 传输内容的字符编码
    public static final String BYE = "bye";  // 关键变量

    public static void main(String[] args) throws IOException {
        commWithClient();
    }

    // 开启与客户端对话
    private static void commWithClient() throws IOException {
        System.out.println("Server端启动，在端口" + SERVER_PORT + "监听... ...");
        try(
                // 新建服务，监听端口
                ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
                Socket socket = serverSocket.accept(); // 等待连接
                ){
            Chat chat = new Chat("客户端","您已经成功连接到我，我们可以开始对话了。",socket);
            chat.chatting();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("程序退出");
    }
}
