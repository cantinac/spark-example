package co.cantina.example;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamSerializer extends StdSerializer<Stream<?>> {

    public static final StreamSerializer INSTANCE = new StreamSerializer();
    
    public StreamSerializer() {
        super(Stream.class, true);
    }
    
    @Override
    public void serialize(final Stream<?> stream, final JsonGenerator jgen, 
                          final SerializerProvider provider) 
        throws IOException, JsonGenerationException {
        
        provider.findValueSerializer(Iterator.class, null)
                .serialize(stream.iterator(), jgen, provider);
    }
}