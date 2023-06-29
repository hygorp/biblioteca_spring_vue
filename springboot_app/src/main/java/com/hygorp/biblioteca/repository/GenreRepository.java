package com.hygorp.biblioteca.repository;

import com.hygorp.biblioteca.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    List<Genre> findAllByName(String name);
}
