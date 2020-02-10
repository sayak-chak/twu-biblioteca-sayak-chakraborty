package com.twu.biblioteca;

import org.junit.jupiter.api.*;

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
        InputOutputStream inputOutputStream;

        @BeforeEach
        public void initialize() {
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            inputOutputStream = mock(InputOutputStream.class);
        }

        @AfterEach
        public void close() {
            out = null;
            System.out.close();
            inputOutputStream = null;
        }

        @Test
        public void testShouldDisplayTheMenu() {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputOutputStream);
            String expectedMenu = EXPECTEDTESTOUTPUTS.menu + "\n";
            bibliotecaApp.displayMenu();

            assertEquals(expectedMenu, out.toString());
        }

        @Test
        public void testShouldDisplayTheListOfBooksAfterChoosingDisplayBooksOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputOutputStream);
            when(inputOutputStream.input()).thenReturn("1", "4");
            try {

                bibliotecaApp.chooseMenuOption();

                verify(bookShelf, times(1)).displayList();
            } catch (QuittingPlaceholderException exception) {
                //Has Quit
            }
        }

        @Test
        public void testShouldNotifyOnChoosingAnInvalidOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputOutputStream);
            when(inputOutputStream.input()).thenReturn("-1", "4");
            String expectedNotification = Message.invalidOption + "\n";
            try {

                bibliotecaApp.chooseMenuOption();

                assertEquals(expectedNotification, out.toString());
            } catch (QuittingPlaceholderException exception) {
                //Has Quit
            }
        }

        @Test
        public void testShouldCheckoutABookOnChoosingCheckoutOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputOutputStream);
            when(inputOutputStream.input()).thenReturn("2", InvalidBook.name, "4");

            try {
                bibliotecaApp.chooseMenuOption();

                verify(bookShelf, times(1)).checkout(InvalidBook.name);
            } catch (QuittingPlaceholderException exception) {
                //Has Quit
            }
        }

        @Test
        public void testShouldReturnABookOnChoosingCheckoutOption() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputOutputStream);
            when(inputOutputStream.input()).thenReturn("2", InvalidBook.name, "4");

            try {
                bibliotecaApp.chooseMenuOption();

                verify(bookShelf, times(1)).checkout(InvalidBook.name);
            } catch (QuittingPlaceholderException exception) {
                //Has Quit
            }
        }

        @Test
        public void testShouldQuitOnlyWhenOptionToQuitIsChosen() throws IOException {
            BookShelf bookShelf = mock(BookShelf.class);
            BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputOutputStream);
            when(inputOutputStream.input()).thenReturn("2", InvalidBook.name, "4");

            try {
                bibliotecaApp.chooseMenuOption();

                verify(bookShelf, times(1)).checkout(InvalidBook.name);
            } catch (QuittingPlaceholderException exception) {
                //Has Quit
            }
        }

    }
}