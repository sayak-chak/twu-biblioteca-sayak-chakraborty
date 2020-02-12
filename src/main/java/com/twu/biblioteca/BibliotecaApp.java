package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {
    private BookShelf bookShelf;
    private AppInteraction appInteraction;

    public BibliotecaApp(BookShelf bookShelf, AppInteraction appInteraction) {
        this.bookShelf = bookShelf;
        this.appInteraction = appInteraction;
    }

    public static void main(String[] args) throws IOException, QuittingPlaceholderException {
        AppInteraction appInteraction = new AppInteraction(new InputOutputStream());
        BookShelf bookShelf = new BookShelf(DummyBooks.getDefaultList(), appInteraction);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookShelf, appInteraction);

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
            case Menu.choiceDisplayBooks:
                bookShelf.displayList();
                break;
            case Menu.choiceCheckout:
                inputBook = appInteraction.readInput();
                bookShelf.checkout(inputBook);
                break;
            case Menu.choiceReturn:
                inputBook = appInteraction.readInput();
                bookShelf.returnItem(inputBook);
                break;
            case Menu.choiceQuit:
                throw new QuittingPlaceholderException();//System.exit(0);
            default:
                appInteraction.invalidOption();
        }
    }


}
