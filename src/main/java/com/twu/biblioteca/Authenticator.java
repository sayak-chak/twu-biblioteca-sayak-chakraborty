package com.twu.biblioteca;

import java.util.HashMap;

import static com.twu.biblioteca.DummyUser.*;

public class Authenticator {
    private static HashMap<Integer, String> userCredentials;
    private static HashMap<Integer, User> userAccounts;   //LIBRARY ID - USER

    static {
        userAccounts = new HashMap<>();
        userCredentials = new HashMap<>();
        User user = new User(name, email, phoneNo);
        userCredentials.put(libraryNumber, password);
        userAccounts.put(libraryNumber, user);
    }

    private AppInteraction appInteraction;

    Authenticator(AppInteraction appInteraction) {
        this.appInteraction = appInteraction;
    }

    public boolean isValidUser(Integer userId, String password) {
        if (!userCredentials.containsKey(userId) || !userCredentials.get(userId).equals(password)) return false;
        printUserInformation(userId); //TODO - violates SRP?
        return true;
    }

    private void printUserInformation(int userId) {
        User user = getUser(userId);

        appInteraction.
                print("Name : " + user.getName() +
                        "\nEmail : " + user.getEmail() +
                        "\nPhone Number : " + user.getPhoneNumber());
    }

    private User getUser(int userId) {
        return userAccounts.get(userId);
    }
}
