package com.hygorp.biblioteca.service;

import com.hygorp.biblioteca.domain.Author;
import com.hygorp.biblioteca.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(Integer id){
        Optional<Author> authorObj = authorRepository.findById(id);
        return authorObj.orElseThrow(()-> new RuntimeException("Author not found"));
    }

    public List<Author> findAuthorsByName(String name){
        return authorRepository.findAllByName(name);
    }

    public void insert(Author obj){
        authorRepository.save(obj);
    }

    public void update(Author obj){
        Author authorObj = findAuthorById(obj.getId());
        authorObj.setName(obj.getName());
        authorObj.getBooks().addAll(obj.getBooks());
        authorRepository.save(authorObj);
    }

    public void delete(Integer id){
        authorRepository.deleteById(id);
    }
}
