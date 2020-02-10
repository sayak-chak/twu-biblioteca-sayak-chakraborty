package com.twu.biblioteca;

import java.util.List;

import static com.twu.biblioteca.Message.*;
import static java.util.Arrays.asList;

public final class Menu {
    private static List<String> menuOptions = asList(menuOptionOne, menuOptionTwo, menuOptionThree, menuOptionFour);

    public static void display() {
        StringBuilder menu = new StringBuilder(Message.instruction + "\n");
        int serialNumber = 1;
        for (String menuOption : menuOptions) {
            menu.append(serialNumber++).append(". ").append(menuOption).append("\n");
        }
        System.out.println(menu.toString().trim());
    }

}
