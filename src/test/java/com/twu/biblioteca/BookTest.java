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
        Book book = new Book(DUMMYBOOKS.BOOKONENAME, DUMMYBOOKS.BOOKONEAUTHOR, DUMMYBOOKS.BOOKONEYEAROFPUBLICATION);
        String expectedOutput = DUMMYBOOKS.BOOKONENAME + "\n";

        System.out.println(book.getName());

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testShouldDisplayTheBookNameAuthorAndYearOfPublication() {
        Book book = new Book(DUMMYBOOKS.BOOKONENAME, DUMMYBOOKS.BOOKONEAUTHOR, DUMMYBOOKS.BOOKONEYEAROFPUBLICATION);
        String expectedOutput = DUMMYBOOKS.BOOKONENAME + " | " + DUMMYBOOKS.BOOKONEAUTHOR + " | " + DUMMYBOOKS.BOOKONEYEAROFPUBLICATION + "\n";

        System.out.println(book.getNameAuthorAndYearOfPublication());


        assertEquals(expectedOutput, outContent.toString());
    }
}