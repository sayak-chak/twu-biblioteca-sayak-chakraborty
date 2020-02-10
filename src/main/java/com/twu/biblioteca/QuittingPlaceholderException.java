package com.twu.biblioteca;

public class QuittingPlaceholderException extends Exception {
    QuittingPlaceholderException() {
        super(Message.quit);
    }
}
