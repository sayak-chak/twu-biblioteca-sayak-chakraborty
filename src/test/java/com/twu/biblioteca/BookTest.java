package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookTest {
    ByteArrayOutputStream outContent; //TODO: private

    @BeforeEach
    public void initialize() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void clear() {
        outContent = null;
        System.out.close();
    }

    @Test
    void testShouldDisplayTheBookName() { // TODO: is this test needed ?
        Book book = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);
        String expectedOutput = DummyBooks.bookOneName + "\n";

        System.out.println(book.getName());

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testShouldDisplayTheBookNameAuthorAndYearOfPublication() { //TODO: do we need to assert on stream ?
        Book book = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);
        String expectedOutput = DummyBooks.bookOneName + " | " + DummyBooks.bookOneAuthor + " | " + DummyBooks.bookOneYearOfPublication + "\n";

        System.out.println(book.getDetails());

        assertEquals(expectedOutput, outContent.toString());
    }
}