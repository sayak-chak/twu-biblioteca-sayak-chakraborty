package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BookShelf {
    private List<Book> books;

    BookShelf() {
        books = new ArrayList<>(Arrays.asList(new Book(DUMMYBOOKS.BOOKONENAME, DUMMYBOOKS.BOOKONEAUTHOR, DUMMYBOOKS.BOOKONEYEAROFPUBLICATION), new Book(DUMMYBOOKS.BOOKTWONAME, DUMMYBOOKS.BOOKTWOAUTHOR, DUMMYBOOKS.BOOKTWOYEAROFPUBLICATION)));
    }

    public void displayListOfBooks() {
        int serialNumber = 1;
        for (Book book : books) {
            System.out.println(serialNumber++ + ". " + book.getNameAuthorAndYearOfPublication());
        }
    }


    public void checkout(String bookName) {
        Book book;
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            book = bookIterator.next();
            if (book.getName().equals(bookName)) {
                bookIterator.remove();
                System.out.println(MESSAGE.SUCCESSFULCHECKOUT);
                return;
            }
        }
        System.out.println(MESSAGE.CHECKOUTFAIL);
    }

}

