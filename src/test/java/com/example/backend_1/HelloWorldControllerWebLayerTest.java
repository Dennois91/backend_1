package com.example.backend_1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class HelloWorldControllerWebLayerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World!")));
    }

    @Test
    public void shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/notfound"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnHelloDennis() throws Exception {
        this.mockMvc.perform(get("/helloParam?fNamn=Dennis"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Dennis")));
    }

    @Test
    public void shouldReturnHelloDennisMasterMannen() throws Exception {
        this.mockMvc.perform(get("/helloParams?fName=Dennis&lName=MasterMannen"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Dennis MasterMannen")));
    }

    @Test
    public void helloParamsList() throws Exception {
        this.mockMvc.perform(get("/helloParamList?list=1,2,3,4,hej"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello [1, 2, 3, 4, hej]")));
    }

    @Test
    public void listTest() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/helloParamList?list=1,2,3,4,hej"))
                .andExpect(status().isOk())
                .andReturn();

        List<String> list = List.of(result.getResponse().getContentAsString().split(" "));
        assert list.get(1).equals("[1,");
        assert !list.get(1).equals(" ");
        assert list.size() == 6;
        assert list.get(5).equals("hej]");
        assert !list.get(5).equals("hej");
        assert list.get(2).equals("2,");
    }
}

