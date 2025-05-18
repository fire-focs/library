package com.example.library.component;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Author author1 = new Author("Лев Толстой");
        Author author2 = new Author("Фёдор Достоевский");
        Author author3 = new Author("Александр Пушкин");

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        bookRepository.save(new Book("Война и мир", author1));
        bookRepository.save(new Book("Анна Каренина", author1));
        bookRepository.save(new Book("Преступление и наказание", author2));
        bookRepository.save(new Book("Идиот", author2));
        bookRepository.save(new Book("Евгений Онегин", author3));
    }
} 