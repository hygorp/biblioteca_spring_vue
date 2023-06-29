package com.hygorp.biblioteca.service;

import com.hygorp.biblioteca.domain.Book;
import com.hygorp.biblioteca.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Integer id){
        Optional<Book> bookObj = bookRepository.findById(id);
        return bookObj.orElseThrow(()-> new RuntimeException("Book not found"));
    }

    public List<Book> findBooksByTitle(String title){
        return bookRepository.findAllByTitle(title);
    }

    public Book insert(Book obj){
        return bookRepository.save(obj);
    }

    public Book update(Book obj){
        Book bookObj = findBookById(obj.getId());
        bookObj.setTitle(obj.getTitle());
        bookObj.setDescription(obj.getDescription());
        bookObj.setYear(obj.getYear());
        bookObj.setPrice(obj.getPrice());
        bookObj.setIsbn(obj.getIsbn());
        bookObj.setImgUrl(obj.getImgUrl());
        bookObj.getAuthors().addAll(obj.getAuthors());
        bookObj.getGenres().addAll(obj.getGenres());
        return bookRepository.save(bookObj);
    }

    public void delete(Integer id){
        bookRepository.deleteById(id);
    }
}
