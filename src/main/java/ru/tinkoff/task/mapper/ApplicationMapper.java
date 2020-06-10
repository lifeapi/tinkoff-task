package ru.tinkoff.task.mapper;

import ru.tinkoff.task.dto.ApplicationDto;
import ru.tinkoff.task.entity.Application;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class ApplicationMapper {

    public static ApplicationDto asDto(Application entity) {
        return entity == null ? null : ApplicationDto.builder()
                .id(entity.getId())
                .clientId(entity.getClientId())
                .productName(entity.getProductName())
                .created(entity.getCreated())
                .build();
    }

    public static List<ApplicationDto> asDto(Collection<Application> entities) {
        return entities == null ? emptyList() : entities.stream().map(ApplicationMapper::asDto).collect(toList());
    }

    public static Application asEntity(ApplicationDto dto) {
        return dto == null ? null : Application.builder()
                .id(dto.getId())
                .clientId(dto.getClientId())
                .productName(dto.getProductName())
                .created(dto.getCreated())
                .build();
    }

    public static List<Application> asEntity(Collection<ApplicationDto> dtos) {
        return dtos == null ? emptyList() : dtos.stream().map(ApplicationMapper::asEntity).collect(toList());
    }
}
