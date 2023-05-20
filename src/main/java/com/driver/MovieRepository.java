package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
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
    public Movie getMovieByName(String movie_name){
        return movie_database.get(movie_name);
    }
    public Director getDirectorByName(String director_name){
        return director_database.get(director_name);
    }
    public void addMovieDirectorPair(String movie_name, String director_name) throws NullPointerException{
        List<String> movieList =new ArrayList<String>();
        if(director_movie_database.containsKey(director_name))
            movieList=director_movie_database.get(director_name);
        if(!movie_database.containsKey(movie_name))
            movieList.add(movie_name);
        director_movie_database.put(director_name, (ArrayList<String>) movieList);
//        if(!director_movie_database.containsKey(director_name))
//            director_movie_database.put(director_name,new ArrayList<Movie>());
//        director_movie_database.get(director_name).add(getMovieByName(movie_name));
//        return "Success";
    }
    public List<String> getMoviesByDirectorName(String director_name){
        List<String> movie_list=new ArrayList<>();
        if(director_movie_database.containsKey(director_name))
            movie_list=director_movie_database.get(director_name);
        return movie_list;
//        for(Movie:director_movie_database.get(director_name)){
//            movie_list.add(movie.getName());
//        }
//        return movie_list;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movie_database.keySet());
    }
    public void deleteDirectorByName(String director_name){
        List<String> movieList= new ArrayList<>();
        if(director_movie_database.containsKey(director_name)) {
            movieList = director_movie_database.get(director_name);
            for(String st:movieList){
                movie_database.remove(st);
            }
            director_movie_database.remove(director_name);
        }
        director_database.remove(director_name);

//        for(int i=0;i<director_database.size();i++){
//            if(director_database.get(i).equals(director_name)) {
//                director_database.remove(director_name);
//                break;
//            }
//        }
//        return "Success";
    }
    public void deleteAllDirector(){
        for(String st:director_movie_database.keySet()){
            List<String> movieList=director_movie_database.get(st);
            for(String str: movieList){
                if(movie_database.containsKey(str))
                    movie_database.remove(str);
            }
            director_database.clear();
        }
        director_movie_database.clear();
//        director_database.clear();
//        director_movie_database.clear();
//        return "Success";
    }
}
