package ru.tinkoff.task.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

import static ru.tinkoff.task.util.Constants.DATE_TIME_FORMAT;


public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime date, JsonGenerator g, SerializerProvider provider) throws IOException {
        g.writeString(date.format(DATE_TIME_FORMAT));
    }
}
