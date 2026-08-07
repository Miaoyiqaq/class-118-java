package Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //创建socket对象
    //socket负责发送或接收这个行为
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);//此处可能因为端口号冲突导致异常
    }
    public void start() throws IOException {
        System.out.println("启动服务器ing");
        while(true) {
            //循环处理
            //1,读取并解析
            //packet负责携带数据和地址信息
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(requestPacket);//未读取到内容时会自动阻塞
            //提取载荷
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());
            //2,根据请求构造响应
            String response = response(request);
            //3,把响应返回到客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //4,打印日志
            System.out.printf("[%s:%d] req: %s; resp: %s\n",requestPacket.getAddress().toString(),requestPacket.getPort(),request ,response);
        }
    }

    public String response(String request) {//模拟构造响应,对于回显服务器这一步可以忽略
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}