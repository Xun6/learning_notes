package StudyInternetSocket;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ShowSocketClass {
    public static void main(String[] args) throws UnknownHostException {
        ServerSocket ss = null;
        Socket s = null;
        InetAddress address = InetAddress.getByName("www.geekbang.com");  // 获取该域名的IP地址
        System.out.println(address);
    }
}
