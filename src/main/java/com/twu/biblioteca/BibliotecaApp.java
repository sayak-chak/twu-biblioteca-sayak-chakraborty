package com.twu.biblioteca;

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

    public void actionOnChoosingAnOptionFromMenu(int choice) {

        switch (choice) {
            case 1: //List of books
                bookShelf.displayListOfBooks();
                break;
            case 4: //Quit
                System.exit(0);
                break;
            default:
                systemMessage.invalidOption();
        }

    }

}
