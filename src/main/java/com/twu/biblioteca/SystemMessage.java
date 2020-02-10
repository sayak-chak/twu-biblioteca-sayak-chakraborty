package com.twu.biblioteca;

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

}
