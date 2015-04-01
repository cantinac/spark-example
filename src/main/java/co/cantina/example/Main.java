package co.cantina.example;

import static co.cantina.example.Application.*;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        
        get("/books", "application/json", (req, res) -> {
            
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