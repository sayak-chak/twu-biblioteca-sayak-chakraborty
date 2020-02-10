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
        String expectedOutput = MESSAGE.welcome + "\n"; // Notice the \n for new line.

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplaySuccessfulCheckoutMessage() {
        systemMessage.successfulCheckout();

        String expectedOutput = MESSAGE.successfulCheckOut + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayCheckoutFailMessage() {
        systemMessage.checkoutFail();

        String expectedOutput = MESSAGE.checkOutFail + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplaySuccessfulReturnMessage() {
        systemMessage.successfulReturn();

        String expectedOutput = MESSAGE.successfulReturn + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayReturnFailMessage() {
        systemMessage.returnFail();

        String expectedOutput = MESSAGE.returnFail + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayInvalidOptionMessage() {
        systemMessage.invalidOption();

        String expectedOutput = MESSAGE.invalidOption + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayTheMenu() {
        systemMessage.menu();

        String expectedOutput = EXPECTEDTESTOUTPUTS.menu + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}