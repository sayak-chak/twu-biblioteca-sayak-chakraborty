package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class BookLibraryTest {
    private BookLibrary bookLibrary;
    private AppInteraction appInteraction;
    private List<Item> bookList;

    @BeforeEach
    public void initialize() {
        appInteraction = mock(AppInteraction.class);
        bookList = DummyBooks.getDefaultList();
        bookLibrary = new BookLibrary(bookList, appInteraction);
    }

    @Test
    public void testShouldOutputListOfBooksWhenShelfHasMultipleBooks() {
        bookLibrary.displayList();

        verify(appInteraction, times(1)).printList(bookList);
    }

    @Test
    public void testShouldDisplaySuccessMessageOnSuccessfulCheckoutOfABook() {
        bookLibrary.checkout(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).successfulCheckout();
    }

    @Test
    public void testShouldDisplayFailureMessageOnUnsuccessfulCheckoutOfABook() {
        bookLibrary.checkout("Invalid book");

        verify(appInteraction, times(1)).checkoutFail();
    }

    @Test
    public void testShouldNotifyOnSuccessfullyReturningABook() {
        bookLibrary.checkout(DummyBooks.bookTwoName);
        bookLibrary.returnItem(DummyBooks.bookTwoName);

        verify(appInteraction, times(1)).successfulReturn();
    }

    @Test
    public void testShouldNotifyOnFailureToReturnABook() {
        bookLibrary.returnItem("Invalid Book");

        verify(appInteraction, times(1)).returnFail();
    }

}