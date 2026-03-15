import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * UDP 回显客户端
 * 功能：向UDP回显服务器发送消息，接收并打印服务器的回显响应
 */
public class UdpEchoClient {
    // 客户端UDP套接字（无需绑定固定端口，系统自动分配）
    private DatagramSocket socket = null;
    // 服务器IP地址
    private String serverIp;
    // 服务器端口号
    private int serverPort;

    /**
     * 构造方法：初始化客户端套接字和服务器地址信息
     * @param serverIp 服务器IP地址
     * @param serverPort 服务器端口号
     * @throws SocketException 套接字创建失败时抛出
     */
    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        // 创建无参DatagramSocket，系统自动分配客户端端口
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    /**
     * 客户端启动方法：持续读取控制台输入，发送请求并接收响应
     * @throws IOException 网络IO异常时抛出
     */
    public void start() throws IOException {
        System.out.println("客户端启动成功...");
        Scanner scanner = new Scanner(System.in);

        // 持续循环，实现多次消息发送
        while (true) {
            // 1. 从控制台读取用户输入的请求消息
            System.out.print("请输入要发送的消息 -> ");
            String request = scanner.next();

            // 2. 构造UDP发送数据包：包含数据、服务器IP、服务器端口
            byte[] requestBytes = request.getBytes();
            DatagramPacket requestPacket = new DatagramPacket(
                    requestBytes,
                    requestBytes.length,
                    InetAddress.getByName(serverIp),
                    serverPort
            );

            // 3. 发送数据包到服务器
            socket.send(requestPacket);

            // 4. 构造UDP接收数据包：准备接收服务器的回显响应
            byte[] responseBytes = new byte[1024]; // 定义缓冲区，接收数据
            DatagramPacket responsePacket = new DatagramPacket(
                    responseBytes,
                    responseBytes.length
            );

            // 5. 阻塞接收服务器响应（无响应则一直等待）
            socket.receive(responsePacket);

            // 6. 解析响应数据并打印（剔除缓冲区空字节）
            String response = new String(
                    responsePacket.getData(),
                    0,
                    responsePacket.getLength()
            );
            System.out.printf("服务器回显 -> %s%n", response);
        }
    }

    // 主方法：程序入口
    public static void main(String[] args) throws IOException {
        // 固定服务器IP（本地回环）和端口，可根据实际情况修改
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}