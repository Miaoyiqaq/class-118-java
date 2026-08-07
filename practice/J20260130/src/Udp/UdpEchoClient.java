package Udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;

    public UdpEchoClient() throws SocketException {
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        System.out.println("客户端启动ing");
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入客户端IP:");
        InetAddress inetAddress = InetAddress.getByName(scanner.next());
        System.out.printf("\n%s","输入端口号:");
        int port = Integer.parseInt(scanner.next());
        InetSocketAddress socketAddress = new InetSocketAddress(inetAddress,port);
        while (true) {
            //1,从控制台读取用户输入

            System.out.println("你要向 " + socketAddress.getAddress() + ":" + socketAddress.getPort() + "说:");
            String send = scanner.next();
            //2,构造请求
            DatagramPacket sendPacket = new DatagramPacket(send.getBytes(), send.getBytes().length,socketAddress);
            //3,发送请求
            socket.send(sendPacket);
            //4,接收回显
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                socket.receive(requestPacket);
                String request = new String(requestPacket.getData(),0,requestPacket.getLength());
                System.out.println("接收到" + requestPacket.getAddress() + ":" + requestPacket.getPort() + "回显内容:" + request);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient();
        udpEchoClient.start();
    }
}