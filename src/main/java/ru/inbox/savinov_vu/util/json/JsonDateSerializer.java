package ru.inbox.savinov_vu.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component
public class JsonDateSerializer extends JsonSerializer<LocalDate> {
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public final void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        String isoDate = format.format(value);
        jgen.writeString(isoDate);
    }
}