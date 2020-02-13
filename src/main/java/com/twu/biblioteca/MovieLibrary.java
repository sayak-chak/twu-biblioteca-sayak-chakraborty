package com.twu.biblioteca;

import java.util.List;

public class MovieLibrary extends Library {
    public MovieLibrary(List<Item> defaultMovies, AppInteraction appInteraction) {
        super(defaultMovies, appInteraction);
    }

    @Override
    public void displayMenu() {
        appInteraction.printList(Menu.movieMenuOptions);
    }
}
