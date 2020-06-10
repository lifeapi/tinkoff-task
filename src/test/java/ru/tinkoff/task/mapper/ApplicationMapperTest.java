package ru.tinkoff.task.mapper;


import org.junit.Test;
import ru.tinkoff.task.dto.ApplicationDto;
import ru.tinkoff.task.entity.Application;

import java.time.LocalDateTime;
import java.util.Collection;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;
import static ru.tinkoff.task.enums.Product.REFINANCING;

public class ApplicationMapperTest {

    final static ApplicationDto dto = ApplicationDto.builder()
            .id(321L)
            .clientId(123L)
            .productName(REFINANCING)
            .created(LocalDateTime.now())
            .build();

    final static Application entity = Application.builder()
            .id(dto.getId())
            .clientId(dto.getClientId())
            .productName(dto.getProductName())
            .created(dto.getCreated())
            .build();


    @Test
    public void asDto() {
        assertEquals(dto, ApplicationMapper.asDto(entity));
        assertNull(ApplicationMapper.asDto((Application) null));
    }

    @Test
    public void asListDto() {
        assertArrayEquals(singletonList(dto).toArray(), ApplicationMapper.asDto(singletonList(entity)).toArray());
        assertNotNull(ApplicationMapper.asDto((Collection<Application>) null));
        assertEquals(0, ApplicationMapper.asDto((Collection<Application>) null).size());
    }

    @Test
    public void asEntity() {
        assertEquals(entity, ApplicationMapper.asEntity(dto));
        assertNull(ApplicationMapper.asEntity((ApplicationDto) null));
    }

    @Test
    public void asListEntity() {
        assertArrayEquals(singletonList(entity).toArray(), ApplicationMapper.asEntity(singletonList(dto)).toArray());
        assertNotNull(ApplicationMapper.asEntity((Collection<ApplicationDto>) null));
        assertEquals(0, ApplicationMapper.asEntity((Collection<ApplicationDto>) null).size());
    }
}
