package ru.tinkoff.task.controller;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.tinkoff.task.TaskApplication;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.tinkoff.task.enums.Product.REFINANCING;

@AutoConfigureMockMvc
@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskApplication.class, webEnvironment = RANDOM_PORT)
@PropertySource("classpath:/application.properties")
@Slf4j
@NoArgsConstructor
public class MainControllerIntegrationTest {

    private static final String BASE_URL = "/client";
    private static final String ACCEPT_HEADER = "Accept";
    private static final String JSON = "application/json";
    private static final String XML = "application/xml";
    private static final String CLIENT_ID = "3";
    private static final String WRONG_CLIENT_ID = "4";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getLastApplicationForClientJSON() throws Exception {
        mockMvc.perform(get(BASE_URL + "/" + CLIENT_ID + "/application/last").header(ACCEPT_HEADER, JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.clientId").value(CLIENT_ID))
                .andExpect(jsonPath("$.productName").value(REFINANCING.name()));
    }

    @Test
    public void getLastApplicationForClientXML() throws Exception {

        mockMvc.perform(get(BASE_URL + "/" + CLIENT_ID + "/application/last").header(ACCEPT_HEADER, XML)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.xpath("/ApplicationDto/clientId/text()").string(
                        Matchers.equalTo(CLIENT_ID)))
                .andExpect(MockMvcResultMatchers.xpath("/ApplicationDto/productName/text()").string(
                        Matchers.equalTo(REFINANCING.name())));
    }

    @Test
    public void getLastApplicationForWrongClient() throws Exception {
        mockMvc.perform(get(BASE_URL + "/" + WRONG_CLIENT_ID + "/application/last").header(ACCEPT_HEADER, JSON)).andExpect(status().is4xxClientError());
    }
}
