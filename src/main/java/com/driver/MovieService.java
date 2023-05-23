package com.driver;

import java.util.List;
import java.util.Optional;

public class MovieService {
    private MovieRepository movieRepository=new MovieRepository();
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movie_name,String director_name) throws RuntimeException{
        Optional<Movie> movieOpt=movieRepository.getMovieByName(movie_name);
        Optional<Director> directorOpt=movieRepository.getDirectorByName(director_name);
        if(movieOpt.isEmpty()){
            throw new RuntimeException();
        }
        if(directorOpt.isEmpty()){
            throw new RuntimeException();
        }
        Director directorObj=directorOpt.get();
        directorObj.setNumberOfMovies(directorObj.getNumberOfMovies()+1);
        movieRepository.addDirector(directorObj);
        movieRepository.addMovieDirectorPair(movie_name,director_name);
    }
    public Movie getMovieByName(String movie_name) throws MovieNameInvalidException{
        Optional<Movie> movieOpt=movieRepository.getMovieByName(movie_name);
        if(movieOpt.isPresent()){
            return movieOpt.get();
        }
        throw new MovieNameInvalidException(movie_name);
    }
    public Director getDirectorByName(String director_name) throws MovieNameInvalidException{
        Optional<Director> directorOpt=movieRepository.getDirectorByName(director_name);
        if(directorOpt.isPresent()){
            return directorOpt.get();
        }
        throw new MovieNameInvalidException(director_name);
    }
    public List<String> getMoviesByDirectorName(String director_name){
        return movieRepository.getMoviesByDirectorName(director_name);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String director_name){
        List<String> movies=getMoviesByDirectorName(director_name);
        movieRepository.deleteDirector(director_name);
        for(String movie: movies){
            movieRepository.deleteMovie(movie);
        }
    }
    public void deleteAllDirector(){
         List<String> director=movieRepository.getAllTeacher();
         for(String direct:director){
             deleteDirectorByName(direct);
         }
    }
}