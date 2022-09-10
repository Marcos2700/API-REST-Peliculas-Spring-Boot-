package com.example.apiMovies.controller;

import com.example.apiMovies.entities.Movie;
import com.example.apiMovies.repository.MoviesRepository;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    private final Logger log = LoggerFactory.getLogger(MoviesController.class);
    private MoviesRepository repository;

    public MoviesController(MoviesRepository repository) {
        this.repository = repository;
    }

    /**
     * URL: http://localhost:8080/api/movies
     */

    /**
     * Obtener todas las peliculas guardadas en base de datos
     * @return List<book> de todas las peliculas
     */
    @GetMapping("/api/movies")
    public List<Movie> findAll(){
        return repository.findAll();
    }

    /**
     * Obtener una pelicula pasando el id
     * @param id
     * @return
     */
    @GetMapping("/api/movies/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id){
        Optional<Movie> movieOpt = repository.findById(id);
        if(movieOpt.isPresent()){
            return ResponseEntity.ok(movieOpt.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Guardar una nueva pelicula en base de datos
     *
     * @param movie
     * @return movie
     */
    @PostMapping("/api/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        if(movie.getId() != null){
            log.warn("Try to update a movie instead of create a new movie");
            return ResponseEntity.badRequest().build();
        }
        Movie result = repository.save(movie);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar informacion de una pelicula existente
     * @param movie
     * @return movie
     */
    @PutMapping("/api/movie")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        if(movie.getId() == null){
            log.warn("Try to create a movie instead of update a movie");
            return ResponseEntity.badRequest().build();
        }
        if(!repository.existsById(movie.getId())){
            log.warn("Try to update a movie that not exist");
            return ResponseEntity.notFound().build();
        }
        Movie result = repository.save(movie);
        return ResponseEntity.ok(result);
    }

    /**
     * Borrar una pelicula de base de datos por su id
     * @param id
     * @return noContent()
     */
    @DeleteMapping("/api/movie/{id}")
    public ResponseEntity<Movie> delete(@PathVariable Long id){
        if(!repository.existsById(id)){
            log.warn("Try to delete a movie that not exist");
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
