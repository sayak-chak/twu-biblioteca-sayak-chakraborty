package com.twu.biblioteca;

public class BibliotecaApp {
    BookShelf bookShelf;

    BibliotecaApp(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public void displayMenu() {
        System.out.println(MESSAGE.MENU);
    }

    public void actionOnChoosingAnOptionFromMenu(int choice) {
        try {
            if (choice == 1) {
                bookShelf.displayListOfBooks();
            } else {
                throw new InvalidOptionException();
            }
        } catch (InvalidOptionException Exception) {
            System.out.println("Please select a valid option!");
        }

    }
}
