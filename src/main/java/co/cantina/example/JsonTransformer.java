package co.cantina.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private final ObjectMapper mapper;
    
    public JsonTransformer(final ObjectMapper mapper) {
        if (mapper == null) {
            throw new IllegalArgumentException("mapper cannot be null");
        }
        this.mapper = mapper;
    }

    @Override
    public String render(Object model) {
        try {
            return mapper.writeValueAsString(model);
        } 
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
