package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class BookLibrary extends Library {

    private static HashMap<Integer, String> userCredentials;

    static {
        userCredentials = new HashMap<>();
        userCredentials.put(DummyUser.libraryNumber, DummyUser.password);
    }

    public BookLibrary(List<Item> defaultBooks, AppInteraction appInteraction) {
        super(defaultBooks, appInteraction);
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
        Integer userId = Integer.parseInt(appInteraction.readInput());
        String password = appInteraction.readInput();
        if (validCredentials(userId, password)) {
            super.returnItem(itemName);
            return;
        }
        appInteraction.returnFail();
    }

    private boolean validCredentials(Integer userId, String password) {
        return userCredentials.containsKey(userId) && userCredentials.get(userId).equals(password);
    }

}

