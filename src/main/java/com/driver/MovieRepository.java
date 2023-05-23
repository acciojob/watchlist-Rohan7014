package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MovieRepository {
    private HashMap<String,Movie> movie_database=new HashMap<>();
    private HashMap<String,Director> director_database=new HashMap<>();
    private HashMap<String, ArrayList<String>> director_movie_database=new HashMap<>();
    public void addMovie(Movie movie){
        movie_database.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        director_database.put(director.getName(),director);
    }
    public void addMovieDirectorPair(String movie_name, String director_name) {
        ArrayList<String> movies=director_movie_database.getOrDefault(director_name,new ArrayList<String>());
        movies.add(movie_name);
        director_movie_database.put(director_name,movies);
    }
    public  Optional<Movie> getMovieByName(String movieName) {
        if(movie_database.containsKey(movieName)){
            return Optional.of(movie_database.get(movieName));
        }
        return Optional.empty();
    }
    public Optional<Director> getDirectorByName(String directorName) {
        if(director_database.containsKey(directorName)){
            return Optional.of(director_database.get(directorName));
        }
        return Optional.empty();
    }
    public List<String> getMoviesByDirectorName(String director_name){
        return director_movie_database.getOrDefault(director_name,new ArrayList<>());
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movie_database.keySet());
    }
    public void deleteDirector(String directorName) {
        director_database.remove(directorName);
        director_movie_database.remove(directorName);
    }
    public void deleteMovie(String movie) {
        movie_database.remove(movie);
    }
    public List<String> getAllTeacher() {
        return new ArrayList<>(director_database.keySet());
    }
}
