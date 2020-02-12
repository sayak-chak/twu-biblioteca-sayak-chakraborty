package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

class MovieLibraryTest {
    private MovieLibrary movieLibrary;
    private AppInteraction appInteraction;
    private List<Item> movieList;

    @BeforeEach
    public void initialize() {
        appInteraction = mock(AppInteraction.class);
        movieList = DummyMovies.getDefaultList();
        movieLibrary = new MovieLibrary(movieList, appInteraction);
    }

    @Test
    public void testShouldOutputListOfMoviesWhenShelfHasMultipleMovies() {
        movieLibrary.displayList();

        verify(appInteraction, times(1)).printList(movieList);
    }

    @Test
    public void testShouldDisplaySuccessMessageOnSuccessfulCheckoutOfAMovie() throws IOException {
        movieLibrary.checkout(DummyMovies.movieOneName);

        verify(appInteraction, times(1)).successfulCheckout();
    }

    @Test
    public void testShouldDisplayFailureMessageOnUnsuccessfulCheckoutOfAMovie() throws IOException {
        movieLibrary.checkout("Invalid movie");

        verify(appInteraction, times(1)).checkoutFail();
    }

}