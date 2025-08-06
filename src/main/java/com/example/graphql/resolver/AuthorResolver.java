package com.example.graphql.resolver;

import com.example.graphql.DTO.AddOrUpdateAuthorInput;
import com.example.graphql.DTO.AddOrUpdateBookInput;
import com.example.graphql.model.Author;
import com.example.graphql.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorResolver {

    private final AuthorService authorService;

    AuthorResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Author> allBooks() {
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public Author getAuthorById(@Argument String id) {
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public Author addOrUpdateAuthor(@Argument("input") AddOrUpdateAuthorInput input) {
        return authorService.saveOrUpdateAuthor(input);
    }

}
