package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MovieTest {
    @Test
    void testShouldDisplayTheMovieName() {
        Movie movie = new Movie(DummyMovies.movieOneName, DummyMovies.movieOneDirector, DummyMovies.movieOneYearOfPublication, DummyMovies.movieOneRating);

        assertEquals(DummyMovies.movieOneName, movie.getName());
    }

    @Test
    void testShouldPrintTheMovieNameDirectorAndYearOfPublication() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Movie movieOne = new Movie(DummyMovies.movieOneName, DummyMovies.movieOneDirector, DummyMovies.movieOneYearOfPublication, DummyMovies.movieOneRating);

        System.out.println(movieOne.getDetails());

        assertEquals(ExpectedTestOutputs.movieOneDetails, outContent.toString());

        System.setOut(System.out);
    }
}