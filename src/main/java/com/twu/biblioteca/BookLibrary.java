package com.twu.biblioteca;

import java.util.List;


public class BookLibrary extends Library<Item> {

    public BookLibrary(List<Item> defaultBooks, AppInteraction appInteraction) {
        super(defaultBooks, appInteraction);
    }

}

