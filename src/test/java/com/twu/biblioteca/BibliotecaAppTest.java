package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
            String expectedMenu = "1. List Of Books" + "\n";

            bibliotecaApp.displayMenu();

            assertEquals(expectedMenu, out.toString());
        }

        @Test
        public void testShouldDisplayTheListOfBooksAfterUserChoosesTheAppropriateOptionFromMenu() throws InvalidOptionException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);

            bibliotecaApp.actionOnChoosingAnOptionFromMenu(1);

            verify(bookShelf, times(1)).displayListOfBooks();
        }

        @Test
        public void testShouldThrowAppropriateExceptionOnChoosingAnInvalidOption() {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf);

            assertThrows(InvalidOptionException.class, () -> bibliotecaApp.actionOnChoosingAnOptionFromMenu(0));
        }
    }

}