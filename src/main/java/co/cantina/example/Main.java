package co.cantina.example;

import static co.cantina.example.Application.*;
import static spark.Spark.*;

public class Main {
    
    private static final String APPLICATION_JSON = "application/json";

    public static void main(String[] args) {
        
        get("/books", APPLICATION_JSON, (req, res) -> {
            
            res.type(APPLICATION_JSON + "; charset=utf-8");
            
            String title = req.queryParams("title"); 
            if (title == null) {
                return bookRepository.findAllBooks();
            }
            else {
                return bookRepository.findBooksByTitle(title);
            }
            
        }, jsonTransformer);
    }
}