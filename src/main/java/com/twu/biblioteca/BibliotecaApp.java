package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {
    BookShelf bookShelf;
    private InputStream inputStream;
    private SystemMessage systemMessage;

    BibliotecaApp(BookShelf bookShelf, InputStream inputStream) {
        this.bookShelf = bookShelf;
        systemMessage = new SystemMessage();
        this.inputStream = inputStream;
    }

    public void displayMenu() {
        Menu.display();
    }

    private void actionOnChoosingAnOptionFromMenu(int choice) throws IOException, QuittingPlaceholderException {
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
                throw new QuittingPlaceholderException();//System.exit(0);
            default:
                systemMessage.invalidOption();
        }
    }

    private String readInput() throws IOException {
        return inputStream.input();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void chooseMenuOption() throws IOException, QuittingPlaceholderException {
        while (true)
            actionOnChoosingAnOptionFromMenu(Integer.parseInt(readInput()));
    }
}
