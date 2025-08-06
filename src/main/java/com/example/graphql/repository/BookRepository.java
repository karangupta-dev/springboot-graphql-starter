
package com.example.graphql.repository;

import com.example.graphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorId(String authorId);

}
