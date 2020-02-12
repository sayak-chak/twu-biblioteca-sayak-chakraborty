package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class BookShelf {
    private List<Book> booksInLibraryNow;
    private List<Book> checkedOutBooks;
    private AppInteraction appInteraction;

    public BookShelf(List<Book> defaultBooks, AppInteraction appInteraction) {
        this.booksInLibraryNow = new ArrayList<>(defaultBooks);
        checkedOutBooks = new ArrayList<>();
        this.appInteraction = appInteraction;
    }

    public static List<Book> getDefaultList() {
        Book bookOne = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);
        Book bookTwo = new Book(DummyBooks.bookTwoName, DummyBooks.bookTwoAuthor, DummyBooks.bookTwoYearOfPublication);
        return Arrays.asList(bookOne, bookTwo);
    }

    public void displayList() {
        appInteraction.printList(booksInLibraryNow);
    }

    public void checkout(String bookName) {
        Book book;
        Iterator<Book> bookIterator = booksInLibraryNow.iterator();
        while (bookIterator.hasNext()) {
            book = bookIterator.next();
            if (book.getName().equals(bookName)) {
                bookIterator.remove();
                appInteraction.successfulCheckout();
                checkedOutBooks.add(book);
                return;
            }
        }
        appInteraction.checkoutFail();
    }

    public void returnBook(String bookName) {
        Book bookToBeReturned = bookToBeReturned(bookName);

        if (bookToBeReturned == null) {
            appInteraction.returnFail();
            return;
        }
        checkedOutBooks.remove(bookToBeReturned);
        booksInLibraryNow.add(bookToBeReturned);
        appInteraction.successfulReturn();
    }

    private Book bookToBeReturned(String bookName) { //TODO: Optional => Optional class isn't changing this so unnecessary atm
        for (Book book : checkedOutBooks)
            if (book.getName().equals(bookName)) return book;
        return null;
    }

}

