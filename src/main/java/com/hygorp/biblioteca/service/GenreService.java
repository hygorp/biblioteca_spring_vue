package com.hygorp.biblioteca.service;

import com.hygorp.biblioteca.domain.Author;
import com.hygorp.biblioteca.domain.Book;
import com.hygorp.biblioteca.domain.Genre;
import com.hygorp.biblioteca.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    private GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }

    public Genre findGenreById(Integer id){
        Optional<Genre> genreObj = genreRepository.findById(id);
        return genreObj.orElseThrow(()-> new RuntimeException("Genre not found"));
    }

    public List<Genre> findGenresByName(String name){
        return genreRepository.findAllByName(name);
    }

    public Genre insert(Genre obj){
        return genreRepository.save(obj);
    }

    public Genre update(Genre obj){
        Genre genreObj = findGenreById(obj.getId());
        genreObj.setName(obj.getName());
        genreObj.getBooks().addAll(obj.getBooks());
        return genreRepository.save(genreObj);
    }

    public void delete(Integer id){
        genreRepository.deleteById(id);
    }
}
