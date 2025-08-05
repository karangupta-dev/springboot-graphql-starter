package com.example.graphql.service;

import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

//    public Author getAuthorById( final int id){
//        return authorRepository.getById();
//    }

}
