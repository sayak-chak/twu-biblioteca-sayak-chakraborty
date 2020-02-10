package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private String name, author;
    private int yearOfPublication;

    public Book(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getName() {
        return this.name;
    }

    public String getDetails() {
        return this.name + " | " + this.author + " | " + this.yearOfPublication;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Book book = (Book) that;
        return yearOfPublication == book.yearOfPublication &&
                name.equals(book.name) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, yearOfPublication);
    }

    @Override
    public String toString() {
        return name + " | " + author + " | " + yearOfPublication;
    }
}
