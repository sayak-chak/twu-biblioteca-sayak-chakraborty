package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookTest {
    ByteArrayOutputStream outContent;

    @BeforeEach
    public void initializeOutputStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testShouldDisplayTheBookName() {
        Book book = new Book(ADUMMYBOOK.NAME, ADUMMYBOOK.AUTHOR, ADUMMYBOOK.YEAROFPUBLICATION);
        String expectedOutput = ADUMMYBOOK.NAME + "\n";

        System.out.println(book.getName());

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testShouldDisplayTheBookNameAuthorAndYearOfPublication() {
        Book book = new Book(ADUMMYBOOK.NAME, ADUMMYBOOK.AUTHOR, ADUMMYBOOK.YEAROFPUBLICATION);
        String expectedOutput = ADUMMYBOOK.NAME + " | " + ADUMMYBOOK.AUTHOR + " | " + ADUMMYBOOK.YEAROFPUBLICATION + "\n";

        System.out.println(book.getAuthorAndYearOfPublication());


        assertEquals(expectedOutput, outContent.toString());
    }
}