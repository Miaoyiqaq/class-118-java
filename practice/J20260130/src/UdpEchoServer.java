import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP 回显服务器
 * 功能：接收客户端消息，原封不动回显给客户端
 */
public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        // 服务器绑定固定端口，客户端需向该端口发送消息
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动成功，监听端口：" + socket.getLocalPort() + "...");
        while (true) {
            // 1. 接收客户端请求
            byte[] requestBytes = new byte[1024];
            DatagramPacket requestPacket = new DatagramPacket(requestBytes, requestBytes.length);
            socket.receive(requestPacket); // 阻塞等待客户端消息
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            // 2. 原封不动回显（核心逻辑：请求即响应）
            String response = request;

            // 3. 构造响应数据包，发送给客户端（从请求包获取客户端地址和端口）
            byte[] responseBytes = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(
                    responseBytes,
                    responseBytes.length,
                    requestPacket.getAddress(),
                    requestPacket.getPort()
            );
            socket.send(responsePacket);

            // 打印日志：客户端信息 + 消息内容
            System.out.printf("客户端[%s:%d] -> %s | 回显 -> %s%n",
                    requestPacket.getAddress().getHostAddress(),
                    requestPacket.getPort(),
                    request,
                    response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}