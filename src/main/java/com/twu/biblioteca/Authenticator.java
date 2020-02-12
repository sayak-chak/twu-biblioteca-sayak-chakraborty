package com.twu.biblioteca;

import java.util.HashMap;

public class Authenticator {
    private static HashMap<Integer, String> userCredentials;

    static {
        userCredentials = new HashMap<>();
        userCredentials.put(DummyUser.libraryNumber, DummyUser.password);
    }

    public boolean isValidUser(Integer userId, String password) {
        return userCredentials.containsKey(userId) && userCredentials.get(userId).equals(password);
    }
}
