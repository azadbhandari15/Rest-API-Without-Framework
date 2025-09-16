import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RestServer {

    public static void main(String[] args) throws Exception {
        HttpServer httpServer=HttpServer.create(new InetSocketAddress(8080),0);

        httpServer.createContext("/hello",new HelloHandler());
        httpServer.createContext("/user",new UserHandler());

        ExecutorService executorService= Executors.newFixedThreadPool(10);
        httpServer.setExecutor(executorService);
        httpServer.start();

        System.out.println("Server Has Started at Port http://localhost:8080");
    }
}
