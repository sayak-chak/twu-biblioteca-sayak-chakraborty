package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BibliotecaAppTest {

    @Nested
    @DisplayName("Menu Test")
    class MenuTest {
        ByteArrayOutputStream out;

        @BeforeEach
        public void initializeOutputStream() {
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
        }

        @Test
        public void testShouldDisplayTheMenu() {
            BibliotecaApp bibliotecaApp = new BibliotecaApp();
            String expectedMenu = "1. List Of Books" + "\n";

            bibliotecaApp.displayMenu();

            assertEquals(expectedMenu, out.toString());
        }

    }

}