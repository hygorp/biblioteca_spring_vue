package com.hygorp.biblioteca.repository;

import com.hygorp.biblioteca.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByTitle(String name);
}
