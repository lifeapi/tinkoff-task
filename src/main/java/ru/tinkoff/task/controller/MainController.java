package ru.tinkoff.task.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.task.dto.ApplicationDto;
import ru.tinkoff.task.service.ClientService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/client")
public class MainController {

    private ClientService clientService;

    @GetMapping(value = "/{clientId}/application/last", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ApplicationDto getLastApplicationForClient(@PathVariable Long clientId) {
        return clientService.getLastApplicationForClient(clientId);
    }

}
