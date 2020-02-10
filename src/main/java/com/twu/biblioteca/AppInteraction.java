package com.twu.biblioteca;

import java.util.List;

public class AppInteraction {
    private InputOutputStream inputOutputStream;

    AppInteraction(InputOutputStream inputOutputStream) {
        this.inputOutputStream = inputOutputStream;
    }

    public void printList(List<Book> list) {
        int serialNumber = 1;
        StringBuilder output = new StringBuilder();
        for (Book book : list) {
            output.append(serialNumber++)
                    .append(". ")
                    .append(book.getDetails())
                    .append("\n");
        }
        inputOutputStream.output(output.toString().trim());
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
