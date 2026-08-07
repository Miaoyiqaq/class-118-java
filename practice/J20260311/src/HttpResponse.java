import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private int statusCode;                 // Status code, e.g., 200, 404, etc.
    private String statusText;              // Status text, e.g., "OK", "Not Found", etc.
    private Map<String, String> headers;    // Response headers
    private String body;                    // Response body
    
    public HttpResponse() {
        this.headers = new HashMap<>();
        this.statusCode = 200;
        this.statusText = "OK";
    }
    
    public HttpResponse(int statusCode, String statusText) {
        this();
        this.statusCode = statusCode;
        this.statusText = statusText;
    }
    
    public HttpResponse(int statusCode, String statusText, String body) {
        this(statusCode, statusText);
        this.body = body;
    }
    
    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }
    
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    public String getStatusText() {
        return statusText;
    }
    
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
    
    public Map<String, String> getHeaders() {
        return headers;
    }
    
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getVersion() {
        return "HTTP/1.1";
    }
    
    // Add response header
    public void addHeader(String name, String value) {
        this.headers.put(name, value);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 ").append(statusCode).append(" ").append(statusText).append("\r\n");
        for (Map.Entry<String, String> header : headers.entrySet()) {
            sb.append(header.getKey()).append(": ").append(header.getValue()).append("\r\n");
        }
        sb.append("\r\n").append(body != null ? body : "");
        return sb.toString();
    }
}
