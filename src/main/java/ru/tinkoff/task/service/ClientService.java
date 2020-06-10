package ru.tinkoff.task.service;

import ru.tinkoff.task.dto.ApplicationDto;

public interface ClientService {
    ApplicationDto getLastApplicationForClient(Long clientId);
}
