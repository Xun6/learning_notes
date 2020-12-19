package StudyInternetSocket.InternetCatch;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * 一个简单的网页内容抓取程序
 */
public class InternetCatchDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("域名解析。。。");
        InetAddress address = InetAddress.getByName("www.hao123.com"); //解析域名
        System.out.println("网站地址为：" + address);
        System.out.println("尝试连接到主机 ... ...");
        Socket s = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(address,80);
        s.connect(socketAddress,10000);  // 连接超时等待
        System.out.println("已经连接到主机，开始模拟发送http请求 ... ...");

        // 创建输出流
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8));
        StringBuffer sb = new StringBuffer();
        //TODO  http协议标准请求头
        sb.append("GET /index.html HTTP/1.1\r\n");
        sb.append("host: www.hao123.com\r\n");
        sb.append("\r\n");
        pw.write(sb.toString());  // 发送请求头内容
        pw.flush();

        System.out.println("请求已经发送，开始读取主页内容 .. .. ..");
        // 创建输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(),StandardCharsets.UTF_8));
        // lambda
        br.lines().forEach(System.out::println);
    }
}
