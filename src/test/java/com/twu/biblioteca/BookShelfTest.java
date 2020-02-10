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
        String expected = DUMMYBOOKS.bookList;
        bookShelf.displayListOfBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABookThatIsInBookList() {
        BookShelf bookShelf = new BookShelf();

        bookShelf.checkout(DUMMYBOOKS.bookTwoName);

        assertEquals(Collections.singletonList(new Book(DUMMYBOOKS.bookOneName, DUMMYBOOKS.bookOneAuthor, DUMMYBOOKS.bookOneYearOfPublication)), bookShelf.booksInLibraryNow);
    }

    @Test
    public void testShouldDisplaySuccessMessageOnSuccessfulCheckoutOfABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.successfulCheckOut + "\n";

        bookShelf.checkout(DUMMYBOOKS.bookTwoName);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldDisplayFailureMessageOnUnsuccessfulCheckoutOfABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.checkOutFail + "\n";

        bookShelf.checkout("Invalid book");

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldReturnABook() {
        BookShelf bookShelf = new BookShelf();

        bookShelf.checkout(DUMMYBOOKS.bookTwoName);
        bookShelf.returnBook(DUMMYBOOKS.bookTwoName);

        assertEquals(Arrays.asList(new Book(DUMMYBOOKS.bookOneName, DUMMYBOOKS.bookOneAuthor, DUMMYBOOKS.bookOneYearOfPublication), new Book(DUMMYBOOKS.bookTwoName, DUMMYBOOKS.bookTwoAuthor, DUMMYBOOKS.bookTwoYearOfPublication)), bookShelf.booksInLibraryNow);
    }

    @Test
    public void testShouldNotifyOnSuccessfullyReturningABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.successfulReturn + "\n";
        bookShelf.checkout(DUMMYBOOKS.bookTwoName);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook(DUMMYBOOKS.bookTwoName);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnFailureToReturnABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.returnFail + "\n";
        bookShelf.checkout(DUMMYBOOKS.bookTwoName);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook("Invalid Book");

        assertEquals(expected, outContent.toString());
    }
}