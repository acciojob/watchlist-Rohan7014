package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie),HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        return new ResponseEntity<>(movieService.addDirector(director), HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie_name){
        return new ResponseEntity<>(movieService.getMovieByName(movie_name),HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String director_name){
        return new ResponseEntity<>(movieService.getDirectorByName(director_name),HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-director-name/{name}")
    public ResponseEntity<List<String>> getMovieByDirectorName(@PathVariable String director_name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director_name),HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movie")
    public ResponseEntity<List<String>> getAllMovie(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-director")
    public ResponseEntity<String> deleteAllDirector(){
        return new ResponseEntity<>(movieService.deleteAllDirector(),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director_name) {
        return new ResponseEntity<>(movieService.deleteDirectorByName(director_name), HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie_name,@RequestParam String director_name){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movie_name,director_name),HttpStatus.CREATED);
    }
}