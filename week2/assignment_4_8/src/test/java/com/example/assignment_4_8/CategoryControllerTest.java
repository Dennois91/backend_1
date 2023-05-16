package com.example.assignment_4_8;

import com.example.assignment_4_8.model.Kategory;
import com.example.assignment_4_8.repository.KategoryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private KategoryRepo mockRepo;

    @BeforeEach
    public void init() {
        Kategory kategory1 = new Kategory(1L, "Gold", null);
        Kategory kategory2 = new Kategory(2L, "Silver", null);
        Kategory kategory3 = new Kategory(3L, "Bronze", null);

        when(this.mockRepo.findById(1L)).thenReturn(Optional.of(kategory1));
        when(this.mockRepo.findById(2L)).thenReturn(Optional.of(kategory2));
        when(this.mockRepo.findById(3L)).thenReturn(Optional.of(kategory3));
        when(this.mockRepo.findAll()).thenReturn(Arrays.asList(kategory1, kategory2, kategory3));
    }


    @Test
    public void getKategoriById() throws Exception {
        this.mockMvc.perform(get("/kategoryById/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Gold\",\"kund\":null}"));
    }

    @Test
    public void kategoryAddTest() throws Exception {
        this.mockMvc.perform(get("/kategory/add?namn=Kalle"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Kategory added Kalle Added")));
    }

    @Test
    public void kategoryDeleteTest() throws Exception {
        this.mockMvc.perform(get("/kategory/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Kategory deleted 1 Deleted")));
    }

    @Test
    public void kategoryAllTest() throws Exception {
        this.mockMvc.perform(get("/kategories"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Gold\",\"kund\":null}" +
                        ",{\"id\":2,\"name\":\"Silver\",\"kund\":null}" +
                        ",{\"id\":3,\"name\":\"Bronze\",\"kund\":null}]"));
    }

    @Test
    void addCategoryPost() throws Exception {
        this.mockMvc.perform(post("/category/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Gold\",\"kund\":null}"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Kategory added Gold Added")));
    }
}
