import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UserHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try{
            if("GET".equalsIgnoreCase(exchange.getRequestMethod())){

                String response="{\"id\":\"1\",\"name\":\"John Doe\",\"email\":\"john.doe@gmail.com\"}";
                exchange.getResponseHeaders().add("Content-Type","application/json");
                exchange.sendResponseHeaders(200,response.getBytes(StandardCharsets.UTF_8).length);
                OutputStream os=exchange.getResponseBody();
                os.write(response.getBytes(StandardCharsets.UTF_8));
                os.close();
            }else{
                String response="{\"Error\":\"Method Not Supported\"}";
                exchange.getResponseHeaders().add("Content-Type","application/json");
                exchange.sendResponseHeaders(405,response.getBytes(StandardCharsets.UTF_8).length);
                OutputStream os=exchange.getResponseBody();
                os.write(response.getBytes(StandardCharsets.UTF_8));
                os.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
