package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookShelfTest {
    ByteArrayOutputStream outContent;

    @BeforeEach
    public void initializeOutputStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testShouldDisplayListOfBooksWhenShelfHasMultipleBooks() {
        BookShelf bookShelf = new BookShelf();
        String expected = "1. " + ADUMMYBOOK.NAME + " | " + ADUMMYBOOK.AUTHOR + " | " + ADUMMYBOOK.YEAROFPUBLICATION + "\n" + "2. " + ADUMMYBOOK.NAME + " | " + ADUMMYBOOK.AUTHOR + " | " + ADUMMYBOOK.YEAROFPUBLICATION + "\n";

        bookShelf.displayListOfBooks();

        assertEquals(expected, outContent.toString());
    }
}