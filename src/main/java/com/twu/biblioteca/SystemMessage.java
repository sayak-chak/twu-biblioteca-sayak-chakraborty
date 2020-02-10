package com.twu.biblioteca;

import java.util.List;

public class SystemMessage {


    public void welcome() {
        System.out.println(Message.welcome);
    }

    public void invalidOption() {
        System.out.println(Message.invalidOption);
    }

    public void returnFail() {
        System.out.println(Message.returnFail);
    }

    public void successfulReturn() {
        System.out.println(Message.successfulReturn);
    }

    public void checkoutFail() {
        System.out.println(Message.checkOutFail);
    }

    public void successfulCheckout() {
        System.out.println(Message.successfulCheckOut);
    }

    public void menu() {
        StringBuilder menu = new StringBuilder();
        List<String> menuList = MENU.MENUOPTIONS.getMenu();
        int serialNumber = 1;
        for (String menuOption : menuList) {
            menu.append(serialNumber++).append(". ").append(menuOption).append("\n");
        }
        System.out.println(menu.toString().trim());
    }
}
