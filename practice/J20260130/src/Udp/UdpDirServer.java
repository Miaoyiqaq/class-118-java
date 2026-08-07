package Udp;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDirServer extends UdpEchoServer {
    public UdpDirServer(int port) throws SocketException {
        super(port);
    }
    @Override
    public String response(String request) {
        HashMap<String,String> dir = new HashMap<>();
        dir.put("小猫","cat");
        dir.put("小狗","dog");
        dir.put("小兔子","rabbit");
        return dir.getOrDefault(request,"[未找到对应字典]");
    }

    public static void main(String[] args) throws IOException {
        UdpDirServer udpDirServer = new UdpDirServer(9090);
        udpDirServer.start();
    }
}
