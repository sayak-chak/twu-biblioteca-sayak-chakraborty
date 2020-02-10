package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookShelfTest {
    ByteArrayOutputStream outContent;
    BookShelf bookShelf;

    @BeforeEach
    public void initialize() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bookShelf = new BookShelf(new InputOutputStream());
    }

    @Test
    public void testShouldDisplayListOfBooksWhenShelfHasMultipleBooks() {
        String expected = EXPECTEDTESTOUTPUTS.bookList;
        bookShelf.displayList();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABookThatIsInBookList() {

        bookShelf.checkout(DummyBooks.bookTwoName);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bookShelf.displayList();
        assertEquals("1. " + DummyBooks.bookOneName + " | " + DummyBooks.bookOneAuthor + " | " + DummyBooks.bookOneYearOfPublication + "\n", outContent.toString());
    }

    @Test
    public void testShouldDisplaySuccessMessageOnSuccessfulCheckoutOfABook() {
        String expected = Message.successfulCheckOut + "\n";

        bookShelf.checkout(DummyBooks.bookTwoName);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldDisplayFailureMessageOnUnsuccessfulCheckoutOfABook() {
        String expected = Message.checkOutFail + "\n";

        bookShelf.checkout("Invalid book");

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldReturnABook() {
        bookShelf.checkout(DummyBooks.bookTwoName);
        bookShelf.returnBook(DummyBooks.bookTwoName);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bookShelf.displayList();

        assertEquals("1. " + DummyBooks.bookOneName + " | " + DummyBooks.bookOneAuthor + " | " + DummyBooks.bookOneYearOfPublication + "\n2. " + DummyBooks.bookTwoName + " | " + DummyBooks.bookTwoAuthor + " | " + DummyBooks.bookTwoYearOfPublication + "\n", outContent.toString());
    }

    @Test
    public void testShouldNotifyOnSuccessfullyReturningABook() {
        String expected = Message.successfulReturn + "\n";
        bookShelf.checkout(DummyBooks.bookTwoName);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook(DummyBooks.bookTwoName);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnFailureToReturnABook() {
        String expected = Message.returnFail + "\n";
        bookShelf.checkout(DummyBooks.bookTwoName);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook("Invalid Book");

        assertEquals(expected, outContent.toString());
    }
}