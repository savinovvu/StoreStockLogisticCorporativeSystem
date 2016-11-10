package ru.inbox.savinov_vu.util.json;

        import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class JsonDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");

    @Override
    public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        String isoDateTime = format.format(value);
        jgen.writeString(isoDateTime);
    }


}