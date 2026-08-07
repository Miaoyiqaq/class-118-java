package Tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    ServerSocket serverSocket = null;
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动ing");
        ExecutorService server = Executors.newCachedThreadPool();
        while(true) {
            //1,连接
            Socket socket = serverSocket.accept();
            server.submit(() -> {
                try {
                    client( socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }
    }

    private void client(Socket socket) throws IOException {
        System.out.printf("%s:%s:%d\n", "客户端上线", socket.getInetAddress(), socket.getPort());
        Scanner inputStream = new Scanner(socket.getInputStream());
        while (inputStream.hasNext()) {
            //2,接收数据
            StringBuilder request = new StringBuilder(inputStream.next());
            System.out.println("接收到数据:" + request);
            //3,返回响应
            response(socket, request);
        }
        System.out.printf("%s:%s:%d\n", "客户端下线", socket.getInetAddress(), socket.getPort());
        socket.close();
    }

    public void response(Socket socket, StringBuilder request) throws IOException {
        String response = request.toString() + "\n";
        socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
        socket.getOutputStream().flush();
        System.out.printf("%s:%s:%d\n","服务器返回数据",socket.getInetAddress(),socket.getPort());
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
