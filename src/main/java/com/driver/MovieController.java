package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private MovieService movieService=new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie_name") String movie_name,@RequestParam("director_name") String director_name){
        try{
            movieService.addMovieDirectorPair(movie_name,director_name);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie_name){
        try {
            Movie movie = null;
            movie = movieService.getMovieByName(movie_name);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String director_name){
        try {
            Director director = null;
            director = movieService.getDirectorByName(director_name);
            return new ResponseEntity<>(director, HttpStatus.CREATED);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-movie-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director_name){
        List<String> movies=null;
        movies=movieService.getMoviesByDirectorName(director_name);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movie")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> allMovie=null;
        allMovie=movieService.findAllMovies();
        return new ResponseEntity<>(allMovie, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director_name") String director_name) {
        movieService.deleteDirectorByName(director_name);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-director")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}