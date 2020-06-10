package ru.tinkoff.task.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;

import static ru.tinkoff.task.util.Constants.DATE_TIME_FORMAT;


public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return StringUtils.isEmpty(parser.getText()) ? null : LocalDateTime.parse(parser.getText(), DATE_TIME_FORMAT);
    }
}
