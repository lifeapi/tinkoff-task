package ru.tinkoff.task.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tinkoff.task.dto.ApplicationDto;
import ru.tinkoff.task.entity.Application;
import ru.tinkoff.task.mapper.ApplicationMapper;
import ru.tinkoff.task.repository.ApplicationRepository;
import ru.tinkoff.task.repository.ClientRepository;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientServiceImpl implements ClientService {

    ApplicationRepository applicationRepository;

    ClientRepository clientRepository;

    @Override
    public ApplicationDto getLastApplicationForClient(Long clientId) {
        clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException(("Client " + clientId + " not found")));
        Application application = applicationRepository.getLastApplicationForClient(clientId);
        return ApplicationMapper.asDto(application);
    }
}
