package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        InputStream inputStream;

        @BeforeEach
        public void initializeOutputStream() {
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            inputStream = mock(InputStream.class);
        }

        @Test
        public void testShouldDisplayTheMenu() {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputStream);
            String expectedMenu = EXPECTEDTESTOUTPUTS.menu + "\n";

            bibliotecaApp.displayMenu();

            assertEquals(expectedMenu, out.toString());
        }

        @Test
        public void testShouldDisplayTheListOfBooksAfterChoosingDisplayBooksOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputStream);
            when(inputStream.input()).thenReturn("1", "4");

            bibliotecaApp.chooseMenuOption();

            verify(bookShelf, times(1)).displayListOfBooks();
        }

        @Test
        public void testShouldNotifyOnChoosingAnInvalidOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputStream);
            when(inputStream.input()).thenReturn("-1", "4");
            String expectedNotification = Message.invalidOption + "\n";

            bibliotecaApp.chooseMenuOption();

            assertEquals(expectedNotification, out.toString());
        }

        @Test
        public void testShouldCheckoutABookOnChoosingCheckoutOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputStream);
            when(inputStream.input()).thenReturn("2", InvalidBook.name, "4");

            bibliotecaApp.chooseMenuOption();

            verify(bookShelf, times(1)).checkout(InvalidBook.name);
        }

        @Test
        public void testShouldReturnABookOnChoosingCheckoutOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputStream);
            when(inputStream.input()).thenReturn("2", InvalidBook.name, "4");

            bibliotecaApp.chooseMenuOption();

            verify(bookShelf, times(1)).checkout(InvalidBook.name);
        }

    }
}