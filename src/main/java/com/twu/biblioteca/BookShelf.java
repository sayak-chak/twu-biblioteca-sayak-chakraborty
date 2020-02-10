package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class BookShelf {
    private List<Book> booksInLibraryNow;
    private List<Book> checkedOutBooks;
    private AppInteraction appInteraction;
    private InputOutputStream inputOutputStream;

    public BookShelf(InputOutputStream inputOutputStream) {
        booksInLibraryNow = getDefaultBookList();
        checkedOutBooks = new ArrayList<>();
        appInteraction = new AppInteraction(inputOutputStream); // TODO: Can be mocked
        this.inputOutputStream = inputOutputStream;
    }

    public void displayList() {
        int serialNumber = 1;
        StringBuilder bookList = new StringBuilder();
        for (Book book : booksInLibraryNow) {
            bookList.append(serialNumber++)
                    .append(". ")
                    .append(book.getDetails())
                    .append("\n");
        }
        inputOutputStream.output(bookList.toString().trim());
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
        for (Book book : checkedOutBooks) if (book.getName().equals(bookName)) return book;
        return null;
    }

    private ArrayList<Book> getDefaultBookList() {
        Book bookOne = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);
        Book bookTwo = new Book(DummyBooks.bookTwoName, DummyBooks.bookTwoAuthor, DummyBooks.bookTwoYearOfPublication);
        return new ArrayList<>(asList(bookOne, bookTwo));
    }

}

