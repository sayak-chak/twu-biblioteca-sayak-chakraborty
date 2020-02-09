package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookTest {
    ByteArrayOutputStream outContent;
    @BeforeEach
    public void initializeOutputStreams(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testShouldDisplayTheBookName() {
        Book book = new Book(ADUMMYBOOK.NAME, ADUMMYBOOK.AUTHOR, ADUMMYBOOK.yearOfPublication);
        String expectedOutput = ADUMMYBOOK.NAME +"\n";

        book.getBookName();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testShouldDisplayTheBookNameAuthorAndYearOfPublication() {
        Book book = new Book(ADUMMYBOOK.NAME, ADUMMYBOOK.AUTHOR, ADUMMYBOOK.yearOfPublication);
        String expectedOutput = ADUMMYBOOK.NAME +" | "+ ADUMMYBOOK.AUTHOR +" | "+ ADUMMYBOOK.yearOfPublication+"\n";
        book.getBookAuthorAndYearOfPublication();


        assertEquals(expectedOutput, outContent.toString());
    }
}