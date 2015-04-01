package co.cantina.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InMemoryBookRepository implements BookRepository {
 
    private final List<Book> books;
    
    public InMemoryBookRepository(final List<Book> books){
        if (books == null || books.isEmpty()) {
            throw new IllegalArgumentException("books list cannot be null or empty");
        }
        this.books = new ArrayList<>(books);
    }
    
    @Override
    public Stream<Book> findBooksByTitle(final String title) {
        return books.stream().filter(b -> b.getTitle().startsWith(title));
    }

    @Override
    public Stream<Book> findAllBooks() {
        return books.stream();
    }
}
