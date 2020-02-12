package com.twu.biblioteca;

import java.util.List;

public class MovieLibrary extends Library<Item> {
    public MovieLibrary(List<Item> defaultMovies, AppInteraction appInteraction) {
        super(defaultMovies, appInteraction);
    }
}
