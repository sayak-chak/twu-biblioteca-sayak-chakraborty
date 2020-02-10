package com.twu.biblioteca;

import java.util.List;

public class SystemMessage {


    public void welcome() {
        System.out.println(MESSAGE.WELCOME);
    }

    public void invalidOption() {
        System.out.println(MESSAGE.INVALIDOPTION);
    }

    public void returnFail() {
        System.out.println(MESSAGE.RETURNFAIL);
    }

    public void successfulReturn() {
        System.out.println(MESSAGE.SUCCESSFULRETURN);
    }

    public void checkoutFail() {
        System.out.println(MESSAGE.CHECKOUTFAIL);
    }

    public void successfulCheckout() {
        System.out.println(MESSAGE.SUCCESSFULCHECKOUT);
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
