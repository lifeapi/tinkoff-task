package ru.tinkoff.task.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.tinkoff.task.entity.Application;
import ru.tinkoff.task.entity.Client;
import ru.tinkoff.task.repository.ApplicationRepository;
import ru.tinkoff.task.repository.ClientRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Before
    public void init() {
        Mockito.doReturn(Application.builder().build()).when(applicationRepository).getLastApplicationForClient(anyLong());
        Mockito.doReturn(Optional.of(Client.builder().build())).when(clientRepository).findById(anyLong());
    }

    @Test
    public void getLastApplicationForClient() {
        clientService.getLastApplicationForClient(1L);
        verify(applicationRepository).getLastApplicationForClient(1L);
        verify(clientRepository).findById(1L);
    }
}
