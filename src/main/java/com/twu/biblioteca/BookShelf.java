package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookShelf {
    List<Book> books;

    BookShelf() {
        books = new ArrayList<>(Arrays.asList(new Book(ADUMMYBOOK.NAME, ADUMMYBOOK.AUTHOR, ADUMMYBOOK.YEAROFPUBLICATION), new Book(ADUMMYBOOK.NAME, ADUMMYBOOK.AUTHOR, ADUMMYBOOK.YEAROFPUBLICATION)));
    }

    public void displayListOfBooks() {
        int serialNumber = 1;
        for (Book book : books) {
            System.out.println(serialNumber++ + ". " + book.getNameAuthorAndYearOfPublication());
        }

    }

}
