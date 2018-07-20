package org.wizzo.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wizzo.service.KafkaProducerService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ChatControllerTest {

    private MockMvc mockMvc;
    private ChatController chatController;
    private KafkaProducerService kafkaProducerService;

    @Before
    public void setUp() {
        chatController = new ChatController(kafkaProducerService);
        mockMvc = MockMvcBuilders.standaloneSetup(chatController).build();
    }

    @Test
    public void shouldReturnSuccessfullyApiVersionFromMethod() {
        assertThat(chatController.getApiVersion().getStatusCode().is2xxSuccessful());
    }

    @Test
    public void shouldReturn200SuccessfullyApiVersionFromWeb() throws Exception {
        mockMvc.perform(get("/api/version").accept(MediaType.ALL)).andExpect(status().isOk());
    }

}