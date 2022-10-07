import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.

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
