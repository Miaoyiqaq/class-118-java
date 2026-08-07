import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public abstract class HttpMessageParser {
    
    /**
     * Parse HTTP request
     */
    public HttpRequest parseHttpRequest(String rawRequest) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader reader = new BufferedReader(new StringReader(rawRequest));
        
        // 解析请求行
        String requestLine = reader.readLine();
        if (requestLine != null) {
            String[] parts = requestLine.split(" ");
            if (parts.length >= 3) {
                request.setMethod(parts[0]);
                String url = parts[1];
                
                // 分离URL和查询参数
                if (url.contains("?")) {
                    String[] urlParts = url.split("\\?", 2);
                    request.setUrl(urlParts[0]);
                    
                    // 解析查询参数
                    String queryString = urlParts[1];
                    request.setQueryParams(parseQueryString(queryString));
                } else {
                    request.setUrl(url);
                }
                
                request.setVersion(parts[2]);
            }
        }
        
        // 解析请求头
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            int separatorIndex = line.indexOf(": ");
            if (separatorIndex > 0) {
                String headerName = line.substring(0, separatorIndex);
                String headerValue = line.substring(separatorIndex + 2);
                request.getHeaders().put(headerName, headerValue);
            }
        }
        
        // 解析请求体
        StringBuilder bodyBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            bodyBuilder.append(line);
        }
        
        String body = bodyBuilder.toString();
        request.setBody(body);
        
        // 如果是POST请求且Content-Type为application/x-www-form-urlencoded，则解析表单数据
        String contentType = request.getHeaders().get("Content-Type");
        if (request.getMethod().equals("POST") && 
            contentType != null && 
            contentType.contains("application/x-www-form-urlencoded")) {
            request.setFormData(parseQueryString(body));
        }
        
        return request;
    }
    
    /**
     * Parse query string or form data
     */
    private Map<String, String> parseQueryString(String queryString) {
        Map<String, String> params = new HashMap<>();
        if (queryString == null || queryString.trim().isEmpty()) {
            return params;
        }
        
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf('=');
            if (idx > 0) {
                try {
                    String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8.name());
                    String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8.name());
                    params.put(key, value);
                } catch (Exception e) {
                    // 解码失败时，直接存储原始值
                    String[] parts = pair.split("=", 2);
                    params.put(parts[0], parts.length > 1 ? parts[1] : "");
                }
            }
        }
        
        return params;
    }
    
    /**
     * Build HTTP response
     */
    public String buildHttpResponse(HttpResponse response) {
        StringBuilder httpResponse = new StringBuilder();
        
        // 状态行
        httpResponse.append(response.getVersion() != null ? response.getVersion() : "HTTP/1.1")
                   .append(" ")
                   .append(response.getStatusCode())
                   .append(" ")
                   .append(response.getStatusText())
                   .append("\r\n");
        
        // 响应头
        for (Map.Entry<String, String> header : response.getHeaders().entrySet()) {
            httpResponse.append(header.getKey())
                       .append(": ")
                       .append(header.getValue())
                       .append("\r\n");
        }
        
        // 响应体长度
        String body = response.getBody();
        if (body != null) {
            httpResponse.append("Content-Length: ")
                       .append(body.getBytes(StandardCharsets.UTF_8).length)
                       .append("\r\n");
        } else {
            httpResponse.append("Content-Length: 0\r\n");
        }
        
        // 空行分隔头部和正文
        httpResponse.append("\r\n");
        
        // 响应体
        if (body != null) {
            httpResponse.append(body);
        }
        
        return httpResponse.toString();
    }
    
    /**
     * Abstract method to handle requests, subclasses need to implement the specific request processing logic
     */
    public abstract HttpResponse handleRequest(HttpRequest request);
}
