package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputOutputStreamTest {

    @Test
    public void testShouldTakeInputHelloAndPrintIt() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new ByteArrayInputStream("Hello".getBytes()));

        InputOutputStream inputOutputStream = new InputOutputStream();

        inputOutputStream.output(inputOutputStream.input());

        assertEquals("Hello\n", output.toString());

    }
}