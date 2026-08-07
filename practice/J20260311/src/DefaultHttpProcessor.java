import java.util.Map;

public class DefaultHttpProcessor extends HttpMessageParser {
    
    @Override
    public HttpResponse handleRequest(HttpRequest request) {
        String method = request.getMethod();
        String url = request.getUrl();
        
        System.out.println("处理 " + method + " 请求: " + url);
        
        // Process according to request method
        switch (method.toUpperCase()) {
            case "GET":
                return handleGetRequest(request);
            case "POST":
                return handlePostRequest(request);
            default:
                // Method not allowed
                HttpResponse response = new HttpResponse(405, "Method Not Allowed");
                response.addHeader("Allow", "GET, POST");
                return response;
        }
    }
    
    protected HttpResponse handleGetRequest(HttpRequest request) {
        String url = request.getUrl();
        
        // Simple routing handling
        if (url.equals("/")) {
            // Return homepage
            String html = "<!DOCTYPE html><html><head><title>Simple HTTP Server</title></head>"
                         + "<body><h1>Welcome to Simple HTTP Server!</h1>"
                         + "<p>Current Time: " + new java.util.Date() + "</p>"
                         + "<form method='post' action='/submit'>"
                         + "<input type='text' name='message' placeholder='Enter message' />"
                         + "<button type='submit'>Submit</button>"
                         + "</form></body></html>";
            
            HttpResponse response = new HttpResponse(200, "OK", html);
            response.addHeader("Content-Type", "text/html; charset=utf-8");
            return response;
        } else if (url.startsWith("/echo")) {
            // Echo query parameters
            Map<String, String> queryParams = request.getQueryParams();
            StringBuilder responseBody = new StringBuilder();
            responseBody.append("<h1>Echo Query Parameters</h1>");
            
            if (!queryParams.isEmpty()) {
                responseBody.append("<ul>");
                for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                    responseBody.append("<li>").append(entry.getKey()).append(" = ").append(entry.getValue()).append("</li>");
                }
                responseBody.append("</ul>");
            } else {
                responseBody.append("<p>No query parameters provided.</p>");
            }
            
            HttpResponse response = new HttpResponse(200, "OK", responseBody.toString());
            response.addHeader("Content-Type", "text/html; charset=utf-8");
            return response;
        } else {
            // 404 Page not found
            HttpResponse response = new HttpResponse(404, "Not Found", "<h1>404 - Page Not Found</h1>");
            response.addHeader("Content-Type", "text/html; charset=utf-8");
            return response;
        }
    }
    
    protected HttpResponse handlePostRequest(HttpRequest request) {
        String url = request.getUrl();
        
        if (url.equals("/submit")) {
            // Handle form submission
            String message = "No message";
            
            // First try to get from form data, if not then from request body
            if (!request.getFormData().isEmpty()) {
                message = request.getFormData().getOrDefault("message", "No message");
            } else if (request.getBody() != null && !request.getBody().isEmpty()) {
                // Try to parse request body as key-value pairs
                String body = request.getBody();
                String[] pairs = body.split("&");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=", 2);
                    if (keyValue.length >= 2 && "message".equals(keyValue[0])) {
                        message = keyValue[1];
                        break;
                    }
                }
            }
            
            String html = "<!DOCTYPE html><html><head><title>Form Submitted</title></head>"
                         + "<body><h1>Form Submitted Successfully!</h1>"
                         + "<p>Your message: " + message + "</p>"
                         + "<a href='/'>Go back home</a></body></html>";
            
            HttpResponse response = new HttpResponse(200, "OK", html);
            response.addHeader("Content-Type", "text/html; charset=utf-8");
            return response;
        } else {
            // 404 Page not found
            HttpResponse response = new HttpResponse(404, "Not Found", "<h1>404 - Page Not Found</h1>");
            response.addHeader("Content-Type", "text/html; charset=utf-8");
            return response;
        }
    }
}
