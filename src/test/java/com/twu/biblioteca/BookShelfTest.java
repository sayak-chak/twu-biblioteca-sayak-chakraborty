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
    public void testShouldDisplayNamesOfBooksWhenShelfHasMultipleBooks() {
        BookShelf bookShelf = new BookShelf();
        String expected = "1. " + ADUMMYBOOK.NAME + "\n" + "2. " + ADUMMYBOOK.NAME + "\n";

        bookShelf.displayListOfNames();

        assertEquals(expected, outContent.toString());
    }
}