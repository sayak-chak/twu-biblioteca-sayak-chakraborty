package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {
    ByteArrayOutputStream out;

    @BeforeEach
    public void initializeOutputStream() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testShouldDisplayTheMenu() {
        Menu menu = new Menu();
        String expectedMenu = "1. List Of Books" + "\n";

        menu.displayMenu();

        assertEquals(expectedMenu, out.toString());
    }
}