package com.twu.biblioteca;

public class BibliotecaApp {
    BookShelf bookShelf;

    BibliotecaApp(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public void displayMenu() {
        System.out.println(MESSAGE.MENU);
    }

    public void actionOnChoosingAnOptionFromMenu() {
        bookShelf.displayListOfBooks();
    }
}
