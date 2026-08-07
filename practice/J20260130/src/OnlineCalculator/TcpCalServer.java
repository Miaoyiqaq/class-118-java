package OnlineCalculator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpCalServer {
    ServerSocket serverSocket = null;

    public TcpCalServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = serverSocket.accept();

            service.submit(() -> {
                try {
                    connect(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void connect(Socket socket) throws IOException {
        System.out.printf("%s[%s:%d]\n","客户端上线",socket.getInetAddress().toString(),socket.getPort());
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            Scanner scannerConnect = new Scanner(inputStream);
            while(scannerConnect.hasNext()) {
                //接收请求
                String requestString = scannerConnect.next();
                Request request = Request.requestFromString(requestString);
                //构造响应
                Response response = calculate(request);
                //返回响应
                outputStream.write(response.responseToString().getBytes());
                outputStream.flush();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.printf("%s[%s:%d]\n","客户端下线",socket.getInetAddress().toString(),socket.getPort());
            socket.close();
        }
    }

    private Response calculate(Request request) {
        double num;
        if(request.getOperator().equals("+")) {
            num = request.getNum1() + request.getNum2();
        } else if (request.getOperator().equals("-")) {
            num = request.getNum1() - request.getNum2();
        } else if (request.getOperator().equals("*")) {
            num = request.getNum1() * request.getNum2();
        } else if (request.getOperator().equals("/")) {
            num = request.getNum1() / request.getNum2();
        }else {
            throw new RuntimeException("错误的运算符" + request.getOperator());
        }
        return new Response(num);
    }

    public static void main(String[] args) throws IOException {
        TcpCalServer tcpCalServer = new TcpCalServer(9090);
        tcpCalServer.start();
    }
}
