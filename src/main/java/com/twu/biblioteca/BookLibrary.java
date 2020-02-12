package com.twu.biblioteca;

import java.io.IOException;
import java.util.List;


public class BookLibrary extends Library {

    public BookLibrary(List<Item> defaultBooks, AppInteraction appInteraction) {
        super(defaultBooks, appInteraction);
    }

    @Override
    public void checkout(String itemName) throws IOException {

        Integer userId = Integer.parseInt(appInteraction.readInput());
        String password = appInteraction.readInput();
        super.checkout(itemName);
    }

}

