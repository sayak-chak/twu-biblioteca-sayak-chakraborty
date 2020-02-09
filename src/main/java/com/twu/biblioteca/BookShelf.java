package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BookShelf {
    public List<Book> booksInLibraryNow;
    private List<Book> checkedOutBooks;

    BookShelf() {
        booksInLibraryNow = new ArrayList<>(Arrays.asList(new Book(DUMMYBOOKS.BOOKONENAME, DUMMYBOOKS.BOOKONEAUTHOR, DUMMYBOOKS.BOOKONEYEAROFPUBLICATION), new Book(DUMMYBOOKS.BOOKTWONAME, DUMMYBOOKS.BOOKTWOAUTHOR, DUMMYBOOKS.BOOKTWOYEAROFPUBLICATION)));
        checkedOutBooks = new ArrayList<>();
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
                System.out.println(MESSAGE.SUCCESSFULCHECKOUT);
                checkedOutBooks.add(book);
                return;
            }
        }
        System.out.println(MESSAGE.CHECKOUTFAIL);
    }

    public void returnBook(String bookName) {
        if (thisBookIsInCheckedOutBooks(bookName)) {
            Book book = bookToBeReturned(bookName);
            checkedOutBooks.remove(book);
            booksInLibraryNow.add(book);
            System.out.println(MESSAGE.SUCCESSFULRETURN);
        } else System.out.println(MESSAGE.RETURNFAIL);
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

