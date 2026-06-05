import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        // Starts a web server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "<html><body style='font-family:sans-serif; text-align:center; margin-top:50px;'>"
                                + "<h1 style='color: #2da44e;'>DEVOPS INTERNAL ASSESSMENT: SUCCESS!</h1>"
                                + "<h2>Hello from Stanley's Ubuntu Web Server Node!</h2>"
                                + "<p>Automated and packaged cleanly using Maven.</p>"
                                + "</body></html>";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        System.out.println("Web server started successfully on port 8080...");
        server.setExecutor(null);
        server.start();
    }
}
