package Tcp;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TcpDirServer extends TcpEchoServer{
    public TcpDirServer(int port) throws IOException {
        super(port);
    }

    @Override
    public void response(Socket socket, StringBuilder request) throws IOException {

        HashMap<String,String> dir = new HashMap<>();
        dir.put("小猫","cat");
        dir.put("小狗","dog");
        String str = dir.getOrDefault(request.toString(),"[未找到对应字典]") + "\n";
        socket.getOutputStream().write(str.getBytes(StandardCharsets.UTF_8));
        socket.getOutputStream().flush();
        System.out.printf("%s:%s:%d:%s\n", "服务器", socket.getInetAddress(), socket.getPort(), str);

    }

    public static void main(String[] args) throws IOException {
        TcpDirServer tcpDirServer = new TcpDirServer(9090);
        tcpDirServer.start();
    }
}
