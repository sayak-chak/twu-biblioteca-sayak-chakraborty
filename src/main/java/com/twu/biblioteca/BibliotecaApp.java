package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {
    BookShelf bookShelf;
    private SystemMessage systemMessage;

    BibliotecaApp(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        systemMessage = new SystemMessage();
    }

    public void displayMenu() {
        Menu.display();
    }

    public void actionOnChoosingAnOptionFromMenu(int choice) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inputBook;
        switch (choice) {
            case 1: //List of books
                bookShelf.displayListOfBooks();
                break;
            case 2: //Checkout
                inputBook = in.readLine();
                bookShelf.checkout(inputBook);
                break;
            case 3://Return
                inputBook = in.readLine();
                bookShelf.returnBook(inputBook);
                break;
            case 4: //Quit
                System.exit(0);
                break;
            default:
                systemMessage.invalidOption();
        }

    }

}
