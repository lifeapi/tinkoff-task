package ru.tinkoff.task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.task.dto.ApplicationDto;
import ru.tinkoff.task.entity.Application;
import ru.tinkoff.task.mapper.ApplicationMapper;
import ru.tinkoff.task.repository.ApplicationRepository;
import ru.tinkoff.task.repository.ClientRepository;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ApplicationRepository applicationRepository;

    private ClientRepository clientRepository;

    @Override
    public ApplicationDto getLastApplicationForClient(Long clientId) {
        clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException(("Client " + clientId + " not found")));
        Application application = applicationRepository.getLastApplicationForClient(clientId);
        return ApplicationMapper.asDto(application);
    }
}
