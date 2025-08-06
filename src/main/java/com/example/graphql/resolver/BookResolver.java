
package com.example.graphql.resolver;

import com.example.graphql.DTO.AddOrUpdateBookInput;
import com.example.graphql.model.Book;
import com.example.graphql.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver {

    private final BookService bookService;

    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.getBookById(id);
    }

    @QueryMapping
    public List<Book> booksByAuthorId(@Argument String id) {
        return bookService.getBooksByAuthorId(id);
    }

    @SchemaMapping(typeName = "Book", field = "authorId")
    public Long getAuthorId(Book book) {
        return book.getAuthor().getId();
    }

    @MutationMapping
    public Book addOrUpdateBook(@Argument("input") AddOrUpdateBookInput input) {
        return bookService.saveOrUpdateBook(input);
    }
}
