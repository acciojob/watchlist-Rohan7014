package com.driver;

public class Director {
    private String name;
    private Integer numberOfMovies;
    private Double imdbRating;

    public Director() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(Integer numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Director(String name, Integer numberOfMovies, Double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}
//String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters