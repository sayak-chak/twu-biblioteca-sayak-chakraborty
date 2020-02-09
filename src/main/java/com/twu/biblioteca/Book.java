package com.twu.biblioteca;

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

    public String getNameAuthorAndYearOfPublication() {
        return this.name + " | " + this.author + " | " + this.yearOfPublication;
    }
}
