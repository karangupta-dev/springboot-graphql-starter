package com.example.graphql.DTO;

import com.example.graphql.model.Book;

import java.util.List;

public class AddOrUpdateAuthorInput {

    private String id;
    private String name;

    private List<Book> books;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
