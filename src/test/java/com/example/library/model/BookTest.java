package com.example.library.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testGettersSetters() {
        Book book = new Book();
        book.setId(2L);
        book.setTitle("Test Book");
        Author author = new Author();
        book.setAuthor(author);
        assertEquals(2L, book.getId());
        assertEquals("Test Book", book.getTitle());
        assertEquals(author, book.getAuthor());
    }

    @Test
    void testConstructor() {
        Author author = new Author("A");
        Book book = new Book("Title", author);
        assertEquals("Title", book.getTitle());
        assertEquals(author, book.getAuthor());
    }

    @Test
    void testAllGettersSetters() {
        Book book = new Book();
        book.setId(321L);
        book.setTitle("BookTitle");
        Author author = new Author();
        book.setAuthor(author);
        assertEquals(321L, book.getId());
        assertEquals("BookTitle", book.getTitle());
        assertEquals(author, book.getAuthor());
    }
} 