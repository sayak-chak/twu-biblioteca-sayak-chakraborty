package com.twu.biblioteca;

public class BibliotecaApp {
    BookShelf bookShelf;

    BibliotecaApp(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void displayMenu() {
        System.out.println(MESSAGE.MENU);
    }

    public void actionOnChoosingAnOptionFromMenu(int choice) {
        bookShelf.displayListOfBooks();
    }
}
