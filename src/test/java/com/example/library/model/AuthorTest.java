package com.example.library.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    @Test
    void testGettersSetters() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");
        Book book = new Book();
        author.setBooks(List.of(book));
        assertEquals(1L, author.getId());
        assertEquals("Test Author", author.getName());
        assertEquals(1, author.getBooks().size());
    }

    @Test
    void testConstructor() {
        Author author = new Author("Name");
        assertEquals("Name", author.getName());
    }

    @Test
    void testAllGettersSetters() {
        Author author = new Author();
        author.setId(123L);
        author.setName("TestName");
        Book book = new Book();
        author.setBooks(List.of(book));
        assertEquals(123L, author.getId());
        assertEquals("TestName", author.getName());
        assertEquals(1, author.getBooks().size());
    }
} 