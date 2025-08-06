
package com.example.graphql.resolver;

import com.example.graphql.DTO.AddBookInput;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.service.AuthorService;
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
    private final AuthorService authorService;

    public BookResolver(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.getBookById(id);
    }

    @SchemaMapping(typeName = "Author", field = "books")
    public List<Book> booksByAuthorId(@Argument String id) {
        return bookService.getBooksByAuthorId(id);
    }

    @SchemaMapping(typeName = "Book", field = "authorId")
    public String getAuthorId(Book book) {
        return book.getAuthor().getId();
    }

    @MutationMapping
    public Book addBook(@Argument("input") AddBookInput input) {
        Author author = new Author();
        author.setId(input.getAuthorId());

        Book book = new Book();
        book.setId(input.getId());
        book.setTitle(input.getTitle());
        book.setAuthor(author);
        book.setPrice(input.getPrice());
        return bookService.addBook(book);
    }
}
