package com.twu.biblioteca;

public class SystemMessage {
    private InputOutputStream inputOutputStream;

    SystemMessage(InputOutputStream inputOutputStream) {
        this.inputOutputStream = inputOutputStream;
    }

    public void welcome() {
        inputOutputStream.output(Message.welcome);
    }

    public void invalidOption() {
        inputOutputStream.output(Message.invalidOption);
    }

    public void returnFail() {
        inputOutputStream.output(Message.returnFail);
    }

    public void successfulReturn() {
        inputOutputStream.output(Message.successfulReturn);
    }

    public void checkoutFail() {
        inputOutputStream.output(Message.checkOutFail);
    }

    public void successfulCheckout() {
        inputOutputStream.output(Message.successfulCheckOut);
    }

}
