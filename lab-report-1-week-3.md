# Lab Report 2

### Part 1 - SearchEngine.java

> The code behind the "Simplest Search Engine" is the SearchEngine.java and Server.java.

SearchEngine.java:
```
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {

    ArrayList<String> query = new ArrayList<String>();
    ArrayList<String> tempResult = new ArrayList<String>();

    public String handleRequest(URI url) {
        if(url.getPath().equals("/")){
            return "Please start adding to the database or searching up the queries!";
        }

        if (url.getPath().equals("/add")){
            String[] parameters = url.getQuery().split("=");
            query.add(parameters[1]);
            return parameters[1] + " added!";
        }

        else{
            System.out.println("Path: " + url.getPath());
            if (url.getPath().equals("/search")){
                String[] parameters = url.getQuery().split("=");
                for(int i = 0; i < query.size(); i++){
                    if(query.get(i).contains(parameters[1])){
                        System.out.println(query.get(i));
                        tempResult.add(query.get(i));
                    }
                }

                String searchResult = String.join(" and ", tempResult);
                
                return searchResult;
            }

            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```

Server.java:
```
// A simple web server using Java's built-in HttpServer

// Examples from https://dzone.com/articles/simple-http-server-in-java were useful references

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

interface URLHandler {
    String handleRequest(URI url);
}

class ServerHttpHandler implements HttpHandler {
    URLHandler handler;
    ServerHttpHandler(URLHandler handler) {
      this.handler = handler;
    }
    public void handle(final HttpExchange exchange) throws IOException {
        // form return body after being handled by program
        try {
            String ret = handler.handleRequest(exchange.getRequestURI());
            // form the return string and write it on the browser
            exchange.sendResponseHeaders(200, ret.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(ret.getBytes());
            os.close();
        } catch(Exception e) {
            String response = e.toString();
            exchange.sendResponseHeaders(500, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}

public class Server {
    public static void start(int port, URLHandler handler) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        //create request entrypoint
        server.createContext("/", new ServerHttpHandler(handler));

        //start the server
        server.start();
        System.out.println("Server Started! Visit http://localhost:" + port + " to visit.");
    }
}
```

### Add and Query

> Here are a few screenshots of adding strings to the Search Engine database and searching up strings.

*anewstringtoadd* is added to the database:
![Image](https://i.imgur.com/4ngNXyw.png)

> The handleRequest method is called when entering in http://localhost:4000/add?s=anewstringtoadd.  The program inputs `/add?s=anewstringtoadd` with `URI url` and uses the variable `ArrayList<String> query` to add *anewstringtoadd* to the database.  Even when you decide to change *anewstringtoadd*, for example to *pineapple*, *anewstringtoadd* will already be in the database after the request is done processing.

*pineapple* is added to the database:
![Image](https://i.imgur.com/xj5sCmb.png)

> The handleRequest method is called when entering in http://localhost:4000/add?s=pineapple.  The program inputs `/add?s=pineapple` with `URI url` and uses the variable `ArrayList<String> query` to add *pineapple* to the database.  Even when you decide to change *pineapple*, for example to *apple*, *pineapple* will already be in the database after the request is done processing.

*apple* is added to the database:
![Image](https://i.imgur.com/mQwYAaQ.png)

> The handleRequest method is called when entering in http://localhost:4000/add?s=apple.  The program inputs `/add?s=apple` with `URI url` and uses the variable `ArrayList<String> query` to add *apple* to the database.  Even when you decide to change *apple*, for example to *banana*, *apple* will already be in the database after the request is done processing.

*app* is searched in the database:
![Image](https://i.imgur.com/QOrpXoK.png)

> The handleRequest method is called when entering in http://localhost:4000/search?s=app.  The program inputs `/search?s=app` with `URI url` and uses the variable `ArrayList<String> query` to search *app* in the database and the variable `ArrayList<String> tempResult` and `String searchResult` to return any string that contains *app* in them.  If this value changes, the `tempResult` and `searchResult` would change as the program would return different results based on what the `query` is.

### Part 2 - Bugs