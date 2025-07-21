
package com.example.graphql.service;

import com.example.graphql.model.Book;
import com.example.graphql.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(String id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }
}
