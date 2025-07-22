package com.example.graphql.resolver;


import com.example.graphql.model.Book;
import com.example.graphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//public class BookQueryResolver implements GraphQLQueryResolver {
//    private final BookRepository bookRepository;
//
//    public BookQueryResolver(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public List<Book> allBooks() {
//        return bookRepository.findAll();
//    }
//}
