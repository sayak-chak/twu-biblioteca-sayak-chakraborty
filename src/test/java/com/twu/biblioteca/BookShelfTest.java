package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class BookShelfTest {
    private BookShelf bookShelf;
    private AppInteraction appInteraction;
    private List<Book> bookList;

    @BeforeEach
    public void initialize() {
        appInteraction = mock(AppInteraction.class);
        bookList = DummyBooks.getDefaultList();
        bookShelf = new BookShelf(bookList, appInteraction);
    }

    @Test
    public void testShouldOutputListOfBooksWhenShelfHasMultipleBooks() {
        bookShelf.displayList();

        verify(appInteraction, times(1)).printList(bookList);
    }

    @Test
    public void testShouldDisplaySuccessMessageOnSuccessfulCheckoutOfABook() {
        bookShelf.checkout(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).successfulCheckout();
    }

    @Test
    public void testShouldDisplayFailureMessageOnUnsuccessfulCheckoutOfABook() {
        bookShelf.checkout("Invalid book");

        verify(appInteraction, times(1)).checkoutFail();
    }

    @Test
    public void testShouldNotifyOnSuccessfullyReturningABook() {
        bookShelf.checkout(DummyBooks.bookTwoName);
        bookShelf.returnItem(DummyBooks.bookTwoName);

        verify(appInteraction, times(1)).successfulReturn();
    }

    @Test
    public void testShouldNotifyOnFailureToReturnABook() {
        bookShelf.returnItem("Invalid Book");

        verify(appInteraction, times(1)).returnFail();
    }

}