package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {
    private BookShelf bookShelf;
    private InputOutputStream inputOutputStream;
    private SystemMessage systemMessage;

    public BibliotecaApp(BookShelf bookShelf, InputOutputStream inputOutputStream) {
        this.bookShelf = bookShelf;
        systemMessage = new SystemMessage(inputOutputStream); //TODO: dependency
        this.inputOutputStream = inputOutputStream;
    }

    public void displayMenu() {
        Menu.display();
    }

    private void actionOnChoosingAnOptionFromMenu(int choice) throws IOException, QuittingPlaceholderException {
        String inputBook;
        switch (choice) { // TODO: switch case
            case 1: //List of books
                bookShelf.displayList();
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
        return inputOutputStream.input();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void chooseMenuOption() throws IOException, QuittingPlaceholderException {
        while (true)
            actionOnChoosingAnOptionFromMenu(Integer.parseInt(readInput()));
    }
}
