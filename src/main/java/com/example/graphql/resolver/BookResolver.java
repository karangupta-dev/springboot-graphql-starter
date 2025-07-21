
package com.example.graphql.resolver;

import com.example.graphql.model.Book;
import com.example.graphql.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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

    @MutationMapping
    public Book addBook(@Argument String id,
                        @Argument String title,
                        @Argument String author,
                        @Argument double price) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        return bookService.addBook(book);
    }
}
