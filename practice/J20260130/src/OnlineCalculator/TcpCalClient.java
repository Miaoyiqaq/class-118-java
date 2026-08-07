package OnlineCalculator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpCalClient {
    Socket socket = null;
    private String ip;
    private int port;

    public TcpCalClient(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        socket = new Socket(ip, port);
    }
    public void start() {
        try(OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream()) {
            Scanner scannerClient = new Scanner(inputStream);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                //输入内容
                System.out.println("输入运算符(+,-,*,/):");
                String operator = scanner.next();
                System.out.println("输入第一个数字");
                double num1 = scanner.nextDouble();
                System.out.println("输入第二个数字");
                double num2 = scanner.nextDouble();
                //构造请求
                Request request = new Request(operator,num1,num2);
                //发送请求
                outputStream.write(request.requestToString().getBytes());
                outputStream.flush();
                //接收请求
                String responseString = scannerClient.next();
                Response response = Response.responseFromString(responseString);
                //打印结果
                System.out.printf("%s[%s:%d]%f\n","服务端返回",socket.getInetAddress().toString(),socket.getPort(),response.getNum());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TcpCalClient tcpCalClient = new TcpCalClient("127.0.0.1",9090);
        tcpCalClient.start();
    }
}
