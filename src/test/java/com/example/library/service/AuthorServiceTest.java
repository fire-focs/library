package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAuthors() {
        when(authorRepository.findAll()).thenReturn(Arrays.asList(new Author("A1")));
        List<Author> authors = authorService.getAllAuthors();
        assertEquals(1, authors.size());
    }

    @Test
    void getAuthorById() {
        Author author = new Author("A1");
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
        Optional<Author> result = authorService.getAuthorById(1L);
        assertTrue(result.isPresent());
        assertEquals("A1", result.get().getName());
    }

    @Test
    void getAuthorById_NotFound() {
        when(authorRepository.findById(2L)).thenReturn(Optional.empty());
        Optional<Author> result = authorService.getAuthorById(2L);
        assertFalse(result.isPresent());
    }

    @Test
    void getBooksByAuthorId() {
        when(bookRepository.findByAuthorId(1L)).thenReturn(Arrays.asList(new Book("B1", null)));
        List<Book> books = authorService.getBooksByAuthorId(1L);
        assertEquals(1, books.size());
    }
} 