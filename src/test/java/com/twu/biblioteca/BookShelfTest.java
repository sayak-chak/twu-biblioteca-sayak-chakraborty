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
        String expected = DUMMYBOOKS.BOOKLIST;
        bookShelf.displayListOfBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABookThatIsInBookList() {
        BookShelf bookShelf = new BookShelf();
        String expected = "1. " + new Book(DUMMYBOOKS.BOOKONENAME, DUMMYBOOKS.BOOKONEAUTHOR, DUMMYBOOKS.BOOKONEYEAROFPUBLICATION).getNameAuthorAndYearOfPublication() + "\n";

        bookShelf.checkout(DUMMYBOOKS.BOOKTWONAME);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bookShelf.displayListOfBooks();

        assertEquals(expected, outContent.toString());
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

}