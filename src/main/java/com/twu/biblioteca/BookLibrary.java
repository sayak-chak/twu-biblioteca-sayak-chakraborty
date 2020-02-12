package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BookLibrary extends Library {

    private Authenticator authenticator;

    public BookLibrary(List<Item> defaultBooks, AppInteraction appInteraction, Authenticator authenticator) {
        super.itemsInLibraryNow = new ArrayList<>(defaultBooks);
        super.checkedOutItems = new ArrayList<>();
        super.appInteraction = appInteraction;
        this.authenticator = authenticator;
    }

    @Override
    public void checkout(String itemName) throws IOException {

        Integer userId = Integer.parseInt(appInteraction.readInput());
        String password = appInteraction.readInput();
        if (validCredentials(userId, password)) {
            super.checkout(itemName);
            return;
        }
        appInteraction.checkoutFail();
    }

    @Override
    public void returnItem(String itemName) throws IOException {
        int userId = Integer.parseInt(appInteraction.readInput());
        String password = appInteraction.readInput();
        if (validCredentials(userId, password)) {
            super.returnItem(itemName);
            return;
        }
        appInteraction.returnFail();
    }


    private boolean validCredentials(Integer userId, String password) {
        return authenticator.validUser(userId, password);
    }

}

