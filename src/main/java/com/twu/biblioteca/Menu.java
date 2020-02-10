package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public final class Menu {
    //TODO: static imports and long list
    //TODO: formatting
    private static List<String> menuOptions = Arrays.asList(Message.menuOptionOne, Message.menuOptionTwo, Message.menuOptionThree, Message.menuOptionFour);

    public static void display() {
        StringBuilder menu = new StringBuilder(Message.instruction + "\n");
        int serialNumber = 1;
        for (String menuOption : menuOptions) {
            menu.append(serialNumber++).append(". ").append(menuOption).append("\n");
        }
        System.out.println(menu.toString().trim());
    }

}
