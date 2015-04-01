package co.cantina.example;

import static com.fasterxml.jackson.core.Version.unknownVersion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.Arrays;
import static java.util.Arrays.asList;

public class Application {

    private static ObjectMapper jacksonObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule("Java 8 Streams", unknownVersion(), 
                asList(StreamSerializer.INSTANCE)));
        return mapper;
    }

    public static final JsonTransformer jsonTransformer = 
        new JsonTransformer(jacksonObjectMapper());

    public static final BookRepository bookRepository = new InMemoryBookRepository(Arrays.asList(
        new Book("Domain Driven Design", "Eric Evans"),
        new Book("Implementing Domain Driven Design", "Vaugn Vernon"),
        new Book("Functional Programming in Scala", "Paul Chiusano and Rúnar Bjarnason")
    ));
}
