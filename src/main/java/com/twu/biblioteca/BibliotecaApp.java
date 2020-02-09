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
            switch (choice) {
                case 1:
                    bookShelf.displayListOfBooks();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidOptionException();
            }

        } catch (InvalidOptionException Exception) {
            System.out.println("Please select a valid option!");
        }

    }
}
