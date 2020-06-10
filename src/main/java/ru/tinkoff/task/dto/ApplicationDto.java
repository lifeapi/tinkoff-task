package ru.tinkoff.task.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tinkoff.task.enums.Product;
import ru.tinkoff.task.util.LocalDateTimeDeserializer;
import ru.tinkoff.task.util.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {

    private Long id;

    private Long clientId;

    private Product productName;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime created;

}
