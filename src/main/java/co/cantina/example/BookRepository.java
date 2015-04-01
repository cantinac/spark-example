package co.cantina.example;

import java.util.stream.Stream;

public interface BookRepository {
    Stream<Book> findBooksByTitle(String title);
    Stream<Book> findAllBooks();
}
