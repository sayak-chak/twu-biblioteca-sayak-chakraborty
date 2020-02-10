package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BookShelf {
    public List<Book> booksInLibraryNow;
    private List<Book> checkedOutBooks;
    private SystemMessage systemMessage;

    BookShelf() {
        booksInLibraryNow = new ArrayList<>(Arrays.asList(new Book(DUMMYBOOKS.bookOneName, DUMMYBOOKS.bookOneAuthor, DUMMYBOOKS.bookOneYearOfPublication), new Book(DUMMYBOOKS.bookTwoName, DUMMYBOOKS.bookTwoAuthor, DUMMYBOOKS.bookTwoYearOfPublication)));
        checkedOutBooks = new ArrayList<>();
        systemMessage = new SystemMessage();
    }

    public void displayListOfBooks() {
        int serialNumber = 1;
        for (Book book : booksInLibraryNow) {
            System.out.println(serialNumber++ + ". " + book.getNameAuthorAndYearOfPublication());
        }
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
        if (thisBookIsInCheckedOutBooks(bookName)) {
            Book book = bookToBeReturned(bookName);
            checkedOutBooks.remove(book);
            booksInLibraryNow.add(book);
            systemMessage.successfulReturn();
        } else systemMessage.returnFail();
    }

    private Book bookToBeReturned(String bookName) {
        for (Book book : checkedOutBooks) if (book.getName().equals(bookName)) return book;
        return null; //DEAD CODE
    }

    private boolean thisBookIsInCheckedOutBooks(String bookName) {
        for (Book book : checkedOutBooks) {
            if (book.getName().equals(bookName)) return true;
        }
        return false;
    }

}

