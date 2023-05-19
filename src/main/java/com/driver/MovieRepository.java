package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class MovieRepository {
    private HashMap<String,Movie> movie_database;
    private HashMap<String,Director> director_database;
    private HashMap<String, ArrayList<Movie>> director_movie_database;

    public MovieRepository() {
        movie_database=new HashMap<>();
        director_database=new HashMap<>();
        director_movie_database=new HashMap<>();
    }
    public String addMovie(Movie movie){
        movie_database.put(movie.getName(),movie);
        return "Movie Successfully Added";
    }
    public String addDirector(Director director){
        director_database.put(director.getName(),director);
        return "Director Added Successfully";
    }
    public Movie getMovieByName(String movie_name){
        return movie_database.get(movie_name);
    }
    public Director getDirectorByName(String director_name){
        return director_database.get(director_name);
    }
    public String addMovieDirectorPair(String movie_name,String director_name){
        if(!director_movie_database.containsKey(director_name))
            director_movie_database.put(director_name,new ArrayList<Movie>());
        director_movie_database.get(director_name).add(getMovieByName(movie_name));
        return "Director with Movie pair is Created";
    }
    public List<String> getMoviesByDirectorName(String director_name){
        List<String> movie_list=new ArrayList<>();
        for(Movie movie:director_movie_database.get(director_name)){
            movie_list.add(movie.getName());
        }
        return movie_list;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movie_database.keySet());
    }
    public String deleteDirectorByName(String director_name)throws NullPointerException{
        for(Movie movie:director_movie_database.get(director_name))
            movie_database.remove(movie.getName());
        director_movie_database.remove(director_name);
        director_database.remove(director_name);
        return "Director Name Deleted";
    }
    public String deleteAllDirector(){
        for(String director_name:director_database.keySet()){
            for(Movie movie:director_movie_database.get(director_name)){
                movie_database.remove(movie.getName());
            }
            director_movie_database.clear();
        }
        director_database.clear();
        return "All Directors Deleted";
    }
}
