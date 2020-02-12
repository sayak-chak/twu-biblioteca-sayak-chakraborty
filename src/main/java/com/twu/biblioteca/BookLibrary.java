package com.twu.biblioteca;

import java.util.List;


public class BookLibrary extends Library {

    public BookLibrary(List<Item> defaultBooks, AppInteraction appInteraction) {
        super(defaultBooks, appInteraction);
    }

    @Override
    public void checkout(String itemName) {
        super.checkout(itemName);
    }

}

