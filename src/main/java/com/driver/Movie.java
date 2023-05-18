package com.driver;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private String name;
    private Integer durationInMinutes;
    private Double imdbRating;

    public Movie() {
    }

    public Movie(String name, Integer durationInMinutes, Double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }
}
//String name, int durationInMinutes, double imdbRating, no-args constructor, all-args constructor and getters-setters