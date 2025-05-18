package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @Test
    void getAllAuthors() throws Exception {
        Mockito.when(authorService.getAllAuthors()).thenReturn(Arrays.asList(new Author("A1"), new Author("A2")));
        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("A1"));
    }

    @Test
    void getAuthorById() throws Exception {
        Author author = new Author("A1");
        Mockito.when(authorService.getAuthorById(1L)).thenReturn(Optional.of(author));
        mockMvc.perform(get("/authors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("A1"));
    }

    @Test
    void getBooksByAuthorId() throws Exception {
        Mockito.when(authorService.getBooksByAuthorId(anyLong())).thenReturn(Arrays.asList(new Book("B1", null)));
        mockMvc.perform(get("/authors/1/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("B1"));
    }

}