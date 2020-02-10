package com.twu.biblioteca;

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
}
