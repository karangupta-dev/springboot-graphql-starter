
package com.example.graphql.service;

import com.example.graphql.DTO.AddOrUpdateBookInput;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        return bookRepo.findById(Long.parseLong(id)).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getBooksByAuthorId(String id) {
        return bookRepo.findByAuthorId(id);
    }

    public Book saveOrUpdateBook(AddOrUpdateBookInput input) {
        Author author = new Author();
        author.setId(input.getAuthorId());

        Book book = new Book();
        if (!Objects.isNull(input.getId())) {
            book.setId(Long.parseLong(input.getId()));
        }
        book.setTitle(input.getTitle());
        book.setAuthor(author);
        book.setPrice(input.getPrice());
        return bookRepo.save(book);
    }

}
