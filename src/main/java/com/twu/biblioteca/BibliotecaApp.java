package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {
    private BookShelf bookShelf;
    private AppInteraction appInteraction;

    public BibliotecaApp(BookShelf bookShelf, InputOutputStream inputOutputStream) {
        this.bookShelf = bookShelf;
        appInteraction = new AppInteraction(inputOutputStream); //TODO: dependency
    }

    public static void main(String[] args) throws IOException, QuittingPlaceholderException {
        InputOutputStream inputOutputStream = new InputOutputStream();
        AppInteraction appInteraction = new AppInteraction(new InputOutputStream());
        BookShelf bookShelf = new BookShelf(BookShelf.getDefaultList(), appInteraction);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, inputOutputStream);

        bibliotecaApp.displayMenu();
        bibliotecaApp.chooseMenuOption();

    }

    public void displayMenu() {
        Menu.display();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void chooseMenuOption() throws IOException, QuittingPlaceholderException {
        while (true)
            actionOnChoosingAnOptionFromMenu(Integer.parseInt(appInteraction.readInput()));
    }

    private void actionOnChoosingAnOptionFromMenu(int choice) throws IOException, QuittingPlaceholderException {
        String inputBook;
        switch (choice) { // TODO: switch case
            case 1: //List of books
                bookShelf.displayList();
                break;
            case 2: //Checkout
                inputBook = appInteraction.readInput();
                bookShelf.checkout(inputBook);
                break;
            case 3://Return
                inputBook = appInteraction.readInput();
                bookShelf.returnBook(inputBook);
                break;
            case 4: //Quit
                throw new QuittingPlaceholderException();//System.exit(0);
            default:
                appInteraction.invalidOption();
        }
    }


}
