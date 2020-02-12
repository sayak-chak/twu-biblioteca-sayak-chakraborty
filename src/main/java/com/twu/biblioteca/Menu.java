package com.twu.biblioteca;

import java.util.List;

import static com.twu.biblioteca.Message.*;
import static java.util.Arrays.asList;

public final class Menu {
    public final static int choiceDisplayBooks = 1, choiceCheckout = 2, choiceReturn = 3, choiceQuit = 4;
    public static List<String> bookMenuOptions = asList(menuOptionOne, menuOptionTwo, menuOptionThree, menuOptionFour);

    public static void display() {
        new AppInteraction(new InputOutputStream()).printList(bookMenuOptions);
    }

}
