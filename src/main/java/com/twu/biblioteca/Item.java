package com.twu.biblioteca;

public interface Item {
    String getName();

    String getDetails();

    @Override
    boolean equals(Object that);

    @Override
    int hashCode();

    @Override
    String toString();
}
