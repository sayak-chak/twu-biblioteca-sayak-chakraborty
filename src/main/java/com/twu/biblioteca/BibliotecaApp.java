package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {
    private BookLibrary bookLibrary;
    private AppInteraction appInteraction;

    public BibliotecaApp(BookLibrary bookLibrary, AppInteraction appInteraction) {
        this.bookLibrary = bookLibrary;
        this.appInteraction = appInteraction;
    }
//
//    public static void main(String[] args) throws IOException, QuittingPlaceholderException {
//        AppInteraction appInteraction = new AppInteraction(new InputOutputStream());
//        BookLibrary bookLibrary = new BookLibrary(DummyBooks.getDefaultList(), appInteraction);
//        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookLibrary, appInteraction);
//
//        bibliotecaApp.displayMenu();
//        bibliotecaApp.chooseMenuOption();
//
//    }

    public void displayMenu() {
        bookLibrary.displayMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void chooseMenuOption() throws IOException, QuittingPlaceholderException {
        while (true)
            actionOnChoosingAnOptionFromMenu(Integer.parseInt(appInteraction.readInput()));
    }

    private void actionOnChoosingAnOptionFromMenu(int choice) throws IOException, QuittingPlaceholderException {
        String inputBook;
        switch (choice) { // TODO: switch case
            case Menu.choiceDisplayBooks:
                bookLibrary.displayList();
                break;
            case Menu.choiceCheckout:
                inputBook = appInteraction.readInput();
                bookLibrary.checkout(inputBook);
                break;
            case Menu.choiceReturn:
                inputBook = appInteraction.readInput();
                bookLibrary.returnItem(inputBook);
                break;
            case Menu.choiceQuit:
                throw new QuittingPlaceholderException();//System.exit(0);
            default:
                appInteraction.invalidOption();
        }
    }


}
