package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class DummyMovies {
    static final String movieOneName = "Dummy Movie One", movieOneDirector = "Dummy Director One";
    static final int movieOneYearOfPublication = 2000, movieOneRating = 8;
    static final String movieTwoName = "Dummy Movie Two", movieTwoDirector = "Dummy Director Two";
    static final int movieTwoYearOfPublication = 2000, movieTwoRating = 10;

    public static List<Item> getDefaultList() {

        Movie movieOne = new Movie(DummyMovies.movieOneName, DummyMovies.movieOneDirector, DummyMovies.movieOneYearOfPublication, DummyMovies.movieOneRating);

        Movie movieTwo = new Movie(DummyMovies.movieTwoName, DummyMovies.movieTwoDirector, DummyMovies.movieTwoYearOfPublication, DummyMovies.movieTwoRating);

        return Arrays.asList(movieOne, movieTwo);

    }
}
