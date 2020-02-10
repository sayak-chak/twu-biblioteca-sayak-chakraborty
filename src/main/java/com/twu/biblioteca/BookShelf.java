package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BookShelf {
    private List<Book> booksInLibraryNow;
    private List<Book> checkedOutBooks;
    private SystemMessage systemMessage;
    InputOutputStream inputOutputStream; //TODO: Private

    BookShelf(InputOutputStream inputOutputStream) {
        //TODO: no need for new ArrayList
        //TODO: default method ?
        booksInLibraryNow = new ArrayList<>(Arrays.asList(new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication), new Book(DummyBooks.bookTwoName, DummyBooks.bookTwoAuthor, DummyBooks.bookTwoYearOfPublication)));
        checkedOutBooks = new ArrayList<>();
        systemMessage = new SystemMessage(inputOutputStream); // TODO: Can be mocked
        this.inputOutputStream = inputOutputStream;
    }

    public void displayListOfBooks() {
        int serialNumber = 1;
        StringBuilder bookList = new StringBuilder();
        for (Book book : booksInLibraryNow) {
            bookList.append(serialNumber++)
                    .append(". ")
                    .append(book.getDetails())
                    .append("\n");
        }
        inputOutputStream.output(bookList.toString().trim());
    } //TODO: books not needed in the name

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

    public List<Book> getBooksInLibraryNow() { //TODO: breaks entire library app. breaks encapsulation just for testing
        return booksInLibraryNow;
    }

    private Book bookToBeReturned(String bookName) { //TODO: Optional
        for (Book book : checkedOutBooks) if (book.getName().equals(bookName)) return book;
        return null; //OR EXCEPTION?
    }

}

