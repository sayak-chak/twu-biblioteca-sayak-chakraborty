package com.twu.biblioteca;

import java.util.List;

public class SystemMessage {


    public void welcome() {
        System.out.println(MESSAGE.welcome);
    }

    public void invalidOption() {
        System.out.println(MESSAGE.invalidOption);
    }

    public void returnFail() {
        System.out.println(MESSAGE.returnFail);
    }

    public void successfulReturn() {
        System.out.println(MESSAGE.successfulReturn);
    }

    public void checkoutFail() {
        System.out.println(MESSAGE.checkOutFail);
    }

    public void successfulCheckout() {
        System.out.println(MESSAGE.successfulCheckOut);
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
