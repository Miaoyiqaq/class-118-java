import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private static final int PORT = 9090;
    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private boolean isRunning = false;
    
    public HttpServer() {
        // 创建固定大小的线程池
        this.threadPool = Executors.newFixedThreadPool(10);
    }
    
    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        isRunning = true;
        System.out.println("HTTP服务器启动成功，监听端口: " + PORT);
        
        while (isRunning) {
            try {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Received new client connection: " + clientSocket.getRemoteSocketAddress());
                
                // Submit request handling task to thread pool
                threadPool.submit(new RequestHandler(clientSocket));
            } catch (IOException e) {
                if (isRunning) {
                    System.err.println("接收客户端连接时发生错误: " + e.getMessage());
                }
            }
        }
    }
    
    public void stop() throws IOException {
        isRunning = false;
        if (serverSocket != null) {
            serverSocket.close();
        }
        threadPool.shutdown();
        System.out.println("HTTP服务器已停止");
    }
    
    // 内部类：处理单个请求
    private static class RequestHandler implements Runnable {
        private Socket clientSocket;
        private HttpMessageParser requestProcessor;
        
        public RequestHandler(Socket socket) {
            this.clientSocket = socket;
            // 使用默认处理器，实际应用中可以替换为自定义处理器
            this.requestProcessor = new DefaultHttpProcessor();
        }
        
        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                
                // 读取完整的HTTP请求
                StringBuilder requestBuilder = new StringBuilder();
                String line;
                boolean isFirstLine = true;
                int contentLength = 0;
                
                while ((line = in.readLine()) != null) {
                    requestBuilder.append(line).append("\n");
                    
                    // Check if it's the first line (request line)
                    if (isFirstLine) {
                        isFirstLine = false;
                    } else if (line.trim().isEmpty()) {
                        // Read empty line, indicating header end, continue to read if there's content
                        break;
                    } else if (line.toLowerCase().startsWith("content-length:")) {
                        // Get Content-Length
                        try {
                            contentLength = Integer.parseInt(line.substring("content-length:".length()).trim());
                        } catch (NumberFormatException e) {
                            contentLength = 0;
                        }
                    }
                }
                
                // 如果有请求体，读取请求体
                if (contentLength > 0) {
                    char[] bodyChars = new char[contentLength];
                    int totalRead = 0;
                    int currentRead;
                    
                    while (totalRead < contentLength && 
                           (currentRead = in.read(bodyChars, totalRead, contentLength - totalRead)) != -1) {
                        totalRead += currentRead;
                    }
                    
                    requestBuilder.append(new String(bodyChars, 0, totalRead));
                }
                
                String rawRequest = requestBuilder.toString();
                System.out.println("Received request:\n" + rawRequest);
                
                // Parse request
                HttpRequest request = requestProcessor.parseHttpRequest(rawRequest);
                
                // Process request and generate response
                HttpResponse response = requestProcessor.handleRequest(request);
                
                // Send response
                String responseStr = requestProcessor.buildHttpResponse(response);
                out.print(responseStr);
                out.flush();
                
            } catch (IOException e) {
                System.err.println("Error processing request: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client connection: " + e.getMessage());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        
        // Add shutdown hook to gracefully close the server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                server.stop();
            } catch (IOException e) {
                System.err.println("Error stopping server: " + e.getMessage());
            }
        }));
        
        try {
            server.start();
        } catch (IOException e) {
            System.err.println("启动服务器时发生错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
