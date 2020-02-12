package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

class BookLibraryTest {
    private BookLibrary bookLibrary;
    private AppInteraction appInteraction;
    private List<Item> bookList;
    private Authenticator authenticator;

    @BeforeEach
    public void initialize() {
        appInteraction = mock(AppInteraction.class);
        bookList = DummyBooks.getDefaultList();
        authenticator = mock(Authenticator.class);
        bookLibrary = new BookLibrary(bookList, appInteraction, authenticator);
    }

    @Test
    public void testShouldOutputListOfBooksWhenShelfHasMultipleBooks() {
        bookLibrary.displayList();

        verify(appInteraction, times(1)).printList(bookList);
    }

    @Test
    public void testShouldDisplaySuccessfulCheckoutMessageWhenUserEntersValidBookToCheckoutAndCorrectCredentials() throws IOException {
        when(appInteraction.readInput()).thenReturn(String.valueOf(DummyUser.libraryNumber), DummyUser.password);
        when(authenticator.validUser(DummyUser.libraryNumber, DummyUser.password)).thenReturn(true);

        bookLibrary.checkout(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).successfulCheckout();
    }

    @Test
    public void testShouldDisplayFailureMessageWhenUserEntersValidBookToCheckoutAndIncorrectPassword() throws IOException {
        when(appInteraction.readInput()).thenReturn(String.valueOf(DummyUser.libraryNumber), "Invalid password");
        when(authenticator.validUser(DummyUser.libraryNumber, "Invalid password")).thenReturn(false);

        bookLibrary.checkout(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).checkoutFail();
    }

    @Test
    public void testShouldFailureMessageWhenUserEntersValidBookToCheckoutAndInvalidUserId() throws IOException {
        when(appInteraction.readInput()).thenReturn(String.valueOf(-100), "Invalid password");
        when(authenticator.validUser(-100, "Invalid password")).thenReturn(false);

        bookLibrary.checkout(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).checkoutFail();
    }

    @Test
    public void testShouldDisplayFailureMessageOnEnteringInvalidBookName() throws IOException {
        when(appInteraction.readInput()).thenReturn(String.valueOf(DummyUser.libraryNumber), DummyUser.password);
        when(authenticator.validUser(DummyUser.libraryNumber, DummyUser.password)).thenReturn(true);

        bookLibrary.checkout("Invalid book");

        verify(appInteraction, times(1)).checkoutFail();
    }

    @Test
    public void testShouldDisplaySuccessfulReturnMessageWhenUserEntersValidBookToReturnAndCorrectCredentials() throws IOException {
        when(appInteraction.readInput()).
                thenReturn(String.valueOf(DummyUser.libraryNumber), DummyUser.password,
                        String.valueOf(DummyUser.libraryNumber), DummyUser.password);
        when(authenticator.validUser(DummyUser.libraryNumber, DummyUser.password)).thenReturn(true, true);

        bookLibrary.checkout(DummyBooks.bookOneName);
        bookLibrary.returnItem(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).successfulReturn();
    }

    @Test
    public void testShouldFailureMessageWhenUserEntersValidBookToReturnAndIncorrectPassword() throws IOException {
        when(appInteraction.readInput()).
                thenReturn(String.valueOf(DummyUser.libraryNumber), DummyUser.password,
                        String.valueOf(DummyUser.libraryNumber), "Invalid password");
        when(authenticator.validUser(DummyUser.libraryNumber, "Invalid Password")).thenReturn(true, false);

        bookLibrary.checkout(DummyBooks.bookOneName);
        bookLibrary.returnItem(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).checkoutFail();
    }

    @Test
    public void testShouldFailureMessageWhenUserEntersValidBookToReturnAndInvalidUserId() throws IOException {
        when(appInteraction.readInput()).
                thenReturn(String.valueOf(DummyUser.libraryNumber), DummyUser.password,
                        String.valueOf(-100), "Invalid password");

        //Valid credentials whle checkout invalid while returning
        when(authenticator.validUser(DummyUser.libraryNumber, DummyUser.password)).thenReturn(true, false);

        bookLibrary.checkout(DummyBooks.bookOneName);
        bookLibrary.returnItem(DummyBooks.bookOneName);

        verify(appInteraction, times(1)).successfulCheckout();
        verify(appInteraction, times(1)).returnFail();
    }

    @Test
    public void testShouldDisplayReturnFailMessageOnEnteringInvalidBookName() throws IOException {
        when(appInteraction.readInput()).
                thenReturn(String.valueOf(DummyUser.libraryNumber), DummyUser.password,
                        String.valueOf(DummyUser.libraryNumber), DummyUser.password);
        when(authenticator.validUser(DummyUser.libraryNumber, DummyUser.password)).thenReturn(true);

        bookLibrary.checkout(DummyBooks.bookOneName);
        bookLibrary.returnItem("Invalid Book");

        verify(appInteraction, times(1)).successfulCheckout();
        verify(appInteraction, times(1)).returnFail();
    }
}