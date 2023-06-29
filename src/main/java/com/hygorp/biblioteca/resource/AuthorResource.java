package com.hygorp.biblioteca.resource;

import com.hygorp.biblioteca.domain.Author;
import com.hygorp.biblioteca.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorResource {

    private final AuthorService authorService;


    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        List<Author> list = authorService.findAllAuthors();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id){
        Author obj = authorService.findAuthorById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Author> insert(@RequestBody Author obj){
        authorService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> update(@RequestBody Author obj, @PathVariable Integer id){
        obj.setId(id);
        authorService.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(Integer id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
