package com.twu.biblioteca;

public class BibliotecaApp {
    BookShelf bookShelf;

    BibliotecaApp(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public void displayMenu() {
        System.out.println(MESSAGE.MENU);
    }

    public void actionOnChoosingAnOptionFromMenu(int choice) throws InvalidOptionException {
        switch (choice) {
            case 1:
                bookShelf.displayListOfBooks();
                break;
            default:
                throw new InvalidOptionException();
        }
    }
}
