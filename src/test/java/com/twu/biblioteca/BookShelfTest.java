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
        String expected = DUMMYBOOKS.BOOKLIST;
        bookShelf.displayListOfBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABookThatIsInBookList() {
        BookShelf bookShelf = new BookShelf();

        bookShelf.checkout(DUMMYBOOKS.BOOKTWONAME);

        assertEquals(Collections.singletonList(new Book(DUMMYBOOKS.BOOKONENAME, DUMMYBOOKS.BOOKONEAUTHOR, DUMMYBOOKS.BOOKONEYEAROFPUBLICATION)), bookShelf.booksInLibraryNow);
    }

    @Test
    public void testShouldDisplaySuccessMessageOnSuccessfulCheckoutOfABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.SUCCESSFULCHECKOUT + "\n";

        bookShelf.checkout(DUMMYBOOKS.BOOKTWONAME);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldDisplayFailureMessageOnUnsuccessfulCheckoutOfABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.CHECKOUTFAIL + "\n";

        bookShelf.checkout("Invalid book");

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldReturnABook() {
        BookShelf bookShelf = new BookShelf();

        bookShelf.checkout(DUMMYBOOKS.BOOKTWONAME);
        bookShelf.returnBook(DUMMYBOOKS.BOOKTWONAME);

        assertEquals(Arrays.asList(new Book(DUMMYBOOKS.BOOKONENAME, DUMMYBOOKS.BOOKONEAUTHOR, DUMMYBOOKS.BOOKONEYEAROFPUBLICATION), new Book(DUMMYBOOKS.BOOKTWONAME, DUMMYBOOKS.BOOKTWOAUTHOR, DUMMYBOOKS.BOOKTWOYEAROFPUBLICATION)), bookShelf.booksInLibraryNow);
    }

    @Test
    public void testShouldNotifyOnSuccessfullyReturningABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.SUCCESSFULRETURN + "\n";
        bookShelf.checkout(DUMMYBOOKS.BOOKTWONAME);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook(DUMMYBOOKS.BOOKTWONAME);

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnFailureToReturnABook() {
        BookShelf bookShelf = new BookShelf();
        String expected = MESSAGE.RETURNFAIL + "\n";
        bookShelf.checkout(DUMMYBOOKS.BOOKTWONAME);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bookShelf.returnBook("Invalid Book");

        assertEquals(expected, outContent.toString());
    }
}