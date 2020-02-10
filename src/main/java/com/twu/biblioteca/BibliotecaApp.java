package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {
    private InputStream inputStream;
    BookShelf bookShelf;
    private SystemMessage systemMessage;

    BibliotecaApp(BookShelf bookShelf, InputStream inputStream) {
        this.bookShelf = bookShelf;
        systemMessage = new SystemMessage();
        this.inputStream = inputStream;
    }

    public void displayMenu() {
        Menu.display();
    }

    private void actionOnChoosingAnOptionFromMenu(int choice) throws IOException {
        String inputBook;
        switch (choice) {
            case 1: //List of books
                bookShelf.displayListOfBooks();
                break;
            case 2: //Checkout
                inputBook = readInput();
                bookShelf.checkout(inputBook);
                break;
            case 3://Return
                inputBook = readInput();
                bookShelf.returnBook(inputBook);
                break;
            case 4: //Quit
                System.exit(0);
                break;
            default:
                systemMessage.invalidOption();
        }
    }

    private String readInput() throws IOException {
        return inputStream.input();
    }


    public void chooseMenuOption() throws IOException {
        actionOnChoosingAnOptionFromMenu(Integer.parseInt(readInput()));
    }
}
