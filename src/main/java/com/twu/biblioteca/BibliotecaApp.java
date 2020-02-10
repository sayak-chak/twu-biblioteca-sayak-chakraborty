package com.twu.biblioteca;

public class BibliotecaApp {
    BookShelf bookShelf;
    private SystemMessage systemMessage;

    BibliotecaApp(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        systemMessage = new SystemMessage();
    }

    public void displayMenu() {
        systemMessage.menu();
    }

    public void actionOnChoosingAnOptionFromMenu(int choice) {

        switch (choice) {
            case 1:
                bookShelf.displayListOfBooks();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                systemMessage.invalidOption();
        }


    }
}
