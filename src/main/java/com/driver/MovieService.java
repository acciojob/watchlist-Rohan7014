package com.driver;

import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class MovieService {
    MovieRepository movieRepository;
    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }
    public Movie getMovieByName(String movie_name){
        return movieRepository.getMovieByName(movie_name);
    }
    public Director getDirectorByName(String director_name){
        return movieRepository.getDirectorByName(director_name);
    }
    public String addMovieDirectorPair(String movie_name,String director_name){
        return movieRepository.addMovieDirectorPair(movie_name,director_name);
    }
    public List<String> getMoviesByDirectorName(String director_name){
        return movieRepository.getMoviesByDirectorName(director_name);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String director_name){
        return movieRepository.deleteDirectorByName(director_name);
    }
    public String deleteAllDirector(){
        return movieRepository.deleteAllDirector();
    }
}