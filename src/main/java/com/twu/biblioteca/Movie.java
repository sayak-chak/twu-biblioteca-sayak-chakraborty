package com.twu.biblioteca;

public class Movie implements Item {
    private String name, director;
    private int yearOfPublication, rating;

    Movie(String name, String director, int yearOfPublication, int rating) {
        this.name = name;
        this.director = director;
        this.yearOfPublication = yearOfPublication;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDetails() {
        return this.name + " | " + this.director + " | " + this.yearOfPublication + " | " + this.rating;
    }
}
