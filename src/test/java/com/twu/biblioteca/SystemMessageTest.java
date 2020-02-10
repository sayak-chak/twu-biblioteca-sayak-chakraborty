package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemMessageTest {
    ByteArrayOutputStream outContent;
    SystemMessage systemMessage;

    @BeforeEach
    public void initializeOutputStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.
        // So, you can normally call
        systemMessage = new SystemMessage();
    }

    @Test
    public void testShouldDisplayTheCorrectWelcomeMessage() {
        systemMessage.welcome();
        //Now you have to validate the output
        String expectedOutput = Message.welcome + "\n"; // Notice the \n for new line.

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplaySuccessfulCheckoutMessage() {
        systemMessage.successfulCheckout();

        String expectedOutput = Message.successfulCheckOut + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayCheckoutFailMessage() {
        systemMessage.checkoutFail();

        String expectedOutput = Message.checkOutFail + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplaySuccessfulReturnMessage() {
        systemMessage.successfulReturn();

        String expectedOutput = Message.successfulReturn + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayReturnFailMessage() {
        systemMessage.returnFail();

        String expectedOutput = Message.returnFail + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayInvalidOptionMessage() {
        systemMessage.invalidOption();

        String expectedOutput = Message.invalidOption + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}