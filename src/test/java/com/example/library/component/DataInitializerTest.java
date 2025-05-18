package com.example.library.component;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataInitializerTest {
    @Test
    void testRun() {
        AuthorRepository authorRepository = mock(AuthorRepository.class);
        BookRepository bookRepository = mock(BookRepository.class);
        DataInitializer initializer = new DataInitializer(authorRepository, bookRepository);
        initializer.run();
        verify(authorRepository, atLeastOnce()).save(any(Author.class));
        verify(bookRepository, atLeastOnce()).save(any(Book.class));
    }

    @Test
    void testConstructor() {
        AuthorRepository authorRepository = mock(AuthorRepository.class);
        BookRepository bookRepository = mock(BookRepository.class);
        DataInitializer initializer = new DataInitializer(authorRepository, bookRepository);
        assertNotNull(initializer);
    }
} 