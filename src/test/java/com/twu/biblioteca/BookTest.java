package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookTest {
    @Test
    void testShouldDisplayTheBookName() {
        Book book = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);

        assertEquals(DummyBooks.bookOneName, book.getName());
    }

    @Test
    void testShouldPrintTheBookNameAuthorAndYearOfPublication() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book bookOne = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);

        System.out.println(bookOne.getDetails());

        assertEquals(ExpectedTestOutputs.bookOneDetails, outContent.toString());

        System.setOut(System.out);
    }
}