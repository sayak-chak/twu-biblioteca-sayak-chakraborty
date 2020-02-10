package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
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
            String expectedMenu = MESSAGE.menu + "\n";

            bibliotecaApp.displayMenu();

            assertEquals(expectedMenu, out.toString());
        }

        @Test
        public void testShouldDisplayTheListOfBooksAfterUserChoosesTheAppropriateOptionFromMenu() {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);

            bibliotecaApp.actionOnChoosingAnOptionFromMenu(1);

            verify(bookShelf, times(1)).displayListOfBooks();
        }

        @Test
        public void testShouldNotifyOnChoosingAnInvalidOption() {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);
            String expectedNotification = MESSAGE.invalidOption + "\n";

            bibliotecaApp.actionOnChoosingAnOptionFromMenu(0);

            assertEquals(expectedNotification, out.toString());
        }
    }

}