package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class BookShelf {
    private List<Book> booksInLibraryNow;
    private List<Book> checkedOutBooks;
    private SystemMessage systemMessage;
    private InputOutputStream inputOutputStream;

    public BookShelf(InputOutputStream inputOutputStream) {
        booksInLibraryNow = getDefaultBookList();
        checkedOutBooks = new ArrayList<>();
        systemMessage = new SystemMessage(inputOutputStream); // TODO: Can be mocked
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
                systemMessage.successfulCheckout();
                checkedOutBooks.add(book);
                return;
            }
        }
        systemMessage.checkoutFail();
    }

    public void returnBook(String bookName) {
        Book bookToBeReturned = bookToBeReturned(bookName);

        if (bookToBeReturned == null) {
            systemMessage.returnFail();
            return;
        }
        checkedOutBooks.remove(bookToBeReturned);
        booksInLibraryNow.add(bookToBeReturned);
        systemMessage.successfulReturn();
    }

    private Book bookToBeReturned(String bookName) { //TODO: Optional
        for (Book book : checkedOutBooks) if (book.getName().equals(bookName)) return book;
        return null; //OR EXCEPTION?
    }

    private ArrayList<Book> getDefaultBookList() {
        Book bookOne = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);
        Book bookTwo = new Book(DummyBooks.bookTwoName, DummyBooks.bookTwoAuthor, DummyBooks.bookTwoYearOfPublication);
        return new ArrayList<>(asList(bookOne, bookTwo));
    }

}

