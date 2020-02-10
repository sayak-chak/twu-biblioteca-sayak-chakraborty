package com.twu.biblioteca;

import java.util.List;

import static com.twu.biblioteca.Message.*;
import static java.util.Arrays.asList;

public final class Menu {
    private static List<String> menuOptions = asList(menuOptionOne, menuOptionTwo, menuOptionThree, menuOptionFour);

    public static void display() {
        new AppInteraction(new InputOutputStream()).printList(menuOptions);
    }

}
