package com.twu.biblioteca;

import java.util.List;


public class BookShelf extends Library<Item> {

    public BookShelf(List<Item> defaultBooks, AppInteraction appInteraction) {
        super(defaultBooks, appInteraction);
    }

}

