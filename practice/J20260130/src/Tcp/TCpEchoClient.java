package Tcp;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCpEchoClient {
    Socket socket = null;
    public TCpEchoClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }
    public void start() throws IOException {
        //1,发送请求
        Scanner scanner = new Scanner(System.in);
        Scanner inputStream = new Scanner(socket.getInputStream());
        while (true) {
            System.out.println("发送内容:");
            String request = scanner.next();
            request = request + "\n";
            socket.getOutputStream().write(request.getBytes());
            socket.getOutputStream().flush();//刷新缓冲区
            //2,接收请求
            StringBuilder response = new StringBuilder(inputStream.next());
            //3,打印日志
            System.out.printf("%s:%s:%d:%s\n", "服务器", socket.getInetAddress(), socket.getPort(), response);
        }
    }
    public static void main(String[] args) throws IOException {
        TCpEchoClient client = new TCpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
