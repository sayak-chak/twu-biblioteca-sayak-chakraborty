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
        Book book = new Book(ADUMMYBOOK.NAME);
        String expectedOutput = ADUMMYBOOK.NAME +"\n";

        book.getBookName();

        assertEquals(expectedOutput, outContent.toString());
    }
}