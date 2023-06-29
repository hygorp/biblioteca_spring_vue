package com.hygorp.biblioteca.resource;

import com.hygorp.biblioteca.domain.Genre;
import com.hygorp.biblioteca.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/genres")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GenreResource {

    private final GenreService genreService;

    public GenreResource(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> findAll(){
        List<Genre> list = genreService.findAllGenres();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genre> findById(@PathVariable Integer id){
        Genre obj = genreService.findGenreById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Genre> insert(@RequestBody Genre obj){
        genreService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Genre> update(@RequestBody Genre obj, @PathVariable Integer id){
        obj.setId(id);
        genreService.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
