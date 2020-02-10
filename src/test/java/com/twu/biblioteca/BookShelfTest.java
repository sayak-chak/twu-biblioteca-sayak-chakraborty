package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

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
        String expected = EXPECTEDTESTOUTPUTS.bookList;
        bookShelf.displayListOfBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABookThatIsInBookList() {
        BookShelf bookShelf = new BookShelf();

        bookShelf.checkout(DummyBooks.bookTwoName);

        assertEquals(Collections.singletonList(new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication)), bookShelf.getBooksInLibraryNow());
    }

    @Test
    public void testShouldDisplaySuccessMessageOnSuccessfulCheckoutOfABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = Message.successfulCheckOut + "\n";

        bookShelf.checkout(DummyBooks.bookTwoName);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldDisplayFailureMessageOnUnsuccessfulCheckoutOfABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = Message.checkOutFail + "\n";

        bookShelf.checkout("Invalid book");

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldReturnABook() {
        BookShelf bookShelf = new BookShelf();

        bookShelf.checkout(DummyBooks.bookTwoName);
        bookShelf.returnBook(DummyBooks.bookTwoName);

        assertEquals(Arrays.asList(new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication), new Book(DummyBooks.bookTwoName, DummyBooks.bookTwoAuthor, DummyBooks.bookTwoYearOfPublication)), bookShelf.getBooksInLibraryNow());
    }

    @Test
    public void testShouldNotifyOnSuccessfullyReturningABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = Message.successfulReturn + "\n";
        bookShelf.checkout(DummyBooks.bookTwoName);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook(DummyBooks.bookTwoName);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnFailureToReturnABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = Message.returnFail + "\n";
        bookShelf.checkout(DummyBooks.bookTwoName);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook("Invalid Book");

        assertEquals(expected, outContent.toString());
    }
}