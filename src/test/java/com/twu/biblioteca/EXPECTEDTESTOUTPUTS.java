package com.twu.biblioteca;

public enum EXPECTEDTESTOUTPUTS {
    ;
    static final String bookList = "1. " + DummyBooks.bookOneName + " | " + DummyBooks.bookOneAuthor + " | " + DummyBooks.bookOneYearOfPublication + "\n" + "2. " + DummyBooks.bookTwoName + " | " + DummyBooks.bookTwoAuthor + " | " + DummyBooks.bookTwoYearOfPublication + "\n";
    static final String menu = "1. List Of Books\n2. Checkout a book\n3. Return a book\n4. Quit";
}
