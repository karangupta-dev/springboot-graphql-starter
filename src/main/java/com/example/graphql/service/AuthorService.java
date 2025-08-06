package com.example.graphql.service;

import com.example.graphql.DTO.AddOrUpdateAuthorInput;
import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAllAuthors(List<Integer> ids) {
        return authorRepository.findAllById(ids);
    }

    public Author getAuthorById(String id) {
        return authorRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public Author saveOrUpdateAuthor(AddOrUpdateAuthorInput input) {
        Author author = new Author();

        if (!Objects.isNull(input.getId())) {
            author.setId(Long.parseLong(input.getId()));
        }

        author.setName(input.getName());
        author.setBooks(input.getBooks());

        return authorRepository.save(author);
    }
}
