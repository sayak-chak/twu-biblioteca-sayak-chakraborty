package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class BibliotecaAppTest {

    @Nested
    @DisplayName("Menu Test")
    class MenuTest {
        ByteArrayOutputStream out;

        @BeforeEach
        public void initializeOutputStream() {
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
        }

        @Test
        public void testShouldDisplayTheMenu() {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);
            String expectedMenu = EXPECTEDTESTOUTPUTS.menu + "\n";

            bibliotecaApp.displayMenu();

            assertEquals(expectedMenu, out.toString());
        }

        @Test
        public void testShouldDisplayTheListOfBooksAfterUserChoosesTheAppropriateOptionFromMenu() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);

            bibliotecaApp.actionOnChoosingAnOptionFromMenu(1);

            verify(bookShelf, times(1)).displayListOfBooks();
        }

        @Test
        public void testShouldNotifyOnChoosingAnInvalidOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);
            String expectedNotification = Message.invalidOption + "\n";

            bibliotecaApp.actionOnChoosingAnOptionFromMenu(-1);

            assertEquals(expectedNotification, out.toString());
        }

        @Test
        public void testShouldCheckoutABookOnChoosingCheckoutOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);
            String invalidBook = InvalidBook.name;
            System.setIn(new ByteArrayInputStream(invalidBook.getBytes()));

            bibliotecaApp.actionOnChoosingAnOptionFromMenu(2);

            verify(bookShelf, times(1)).checkout(invalidBook);
        }

        @Test
        public void testShouldReturnABookOnChoosingCheckoutOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);
            String invalidBook = InvalidBook.name;
            System.setIn(new ByteArrayInputStream(invalidBook.getBytes()));

            bibliotecaApp.actionOnChoosingAnOptionFromMenu(3);

            verify(bookShelf, times(1)).returnBook(invalidBook);
        }
    }

}