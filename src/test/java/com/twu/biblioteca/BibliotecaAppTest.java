package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


class BibliotecaAppTest {

    private BookLibrary bookLibrary;
    private AppInteraction appInteraction;
    private BibliotecaApp bibliotecaApp;

    @BeforeEach
    public void initialize() {
        bookLibrary = mock(BookLibrary.class);
        appInteraction = mock(AppInteraction.class);
        bibliotecaApp = new BibliotecaApp(bookLibrary, appInteraction);
    }

    @Test
    public void testShouldDisplayTheMenu() {

        bibliotecaApp.displayMenu();

        verify(bookLibrary, times(1)).displayMenu();
    }

    @Test
    public void testShouldDisplayTheListOfBooksAfterChoosingDisplayBooksOption() throws IOException {
        try {
            when(appInteraction.readInput()).thenReturn("1", "4");

            bibliotecaApp.chooseMenuOption();

        } catch (QuittingPlaceholderException exception) {//Has Quit

            verify(bookLibrary, times(1)).displayList();
        }
    }

    @Test
    public void testShouldNotifyOnChoosingAnInvalidOption() throws IOException {
        try {
            when(appInteraction.readInput()).thenReturn("-1", "4");

            bibliotecaApp.chooseMenuOption();

        } catch (QuittingPlaceholderException exception) {//Has Quit

            verify(appInteraction, times(1)).invalidOption();
        }
    }

    @Test
    public void testShouldCheckoutABookOnChoosingCheckoutOption() throws IOException {
        try {
            when(appInteraction.readInput()).thenReturn("2", InvalidBook.name, "4");

            bibliotecaApp.chooseMenuOption();

        } catch (QuittingPlaceholderException exception) {//Has Quit

            verify(bookLibrary, times(1)).checkout(InvalidBook.name);
        }
    }

    @Test
    public void testShouldReturnABookOnChoosingReturnOption() throws IOException {
        try {
            when(appInteraction.readInput()).thenReturn("3", InvalidBook.name, "4");

            bibliotecaApp.chooseMenuOption();

        } catch (QuittingPlaceholderException exception) { //Has Quit

            verify(bookLibrary, times(1)).returnItem(InvalidBook.name);
        }
    }

    @Test
    public void testShouldQuitOnlyWhenOptionToQuitIsChosen() throws IOException {
        when(appInteraction.readInput()).thenReturn("1", "1232", "2", "23", "3", "4");

        try {
            bibliotecaApp.chooseMenuOption();

        } catch (QuittingPlaceholderException exception) {
            //Has Quit
        }
    }


}