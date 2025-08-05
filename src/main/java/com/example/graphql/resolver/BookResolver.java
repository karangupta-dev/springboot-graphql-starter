
package com.example.graphql.resolver;

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

//    @SchemaMapping(typeName = "Author", field = "books")
//    public List<Book> booksByAuthorId(@Argument String id) {
//        return bookService.getBooksByAuthorId(id);
//    }

    @MutationMapping
    public Book addBook(@Argument String id,
                        @Argument String title,
                        @Argument String authorId,
                        @Argument double price) {


//        Author author =


        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
//        book.setAuthor(author);
        book.setPrice(price);
        return bookService.addBook(book);
    }
}
