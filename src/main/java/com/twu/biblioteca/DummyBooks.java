package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public final class DummyBooks {
    static final String bookOneName = "Dummy Book One", bookOneAuthor = "Dummy Author One";
    static final int bookOneYearOfPublication = 2000;
    static final String bookTwoName = "Dummy Book Two", bookTwoAuthor = "Dummy Author Two";
    static final int bookTwoYearOfPublication = 2000;

    public static List<Item> getDefaultList() {
        Book bookOne = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);
        Book bookTwo = new Book(DummyBooks.bookTwoName, DummyBooks.bookTwoAuthor, DummyBooks.bookTwoYearOfPublication);
        return Arrays.asList(bookOne, bookTwo);

    }
}
