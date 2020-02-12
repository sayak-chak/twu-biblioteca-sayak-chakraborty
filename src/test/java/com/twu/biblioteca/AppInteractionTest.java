package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppInteractionTest {
    private ByteArrayOutputStream outContent;
    private AppInteraction appInteraction;

    @BeforeEach
    public void initializeOutputStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        InputOutputStream inputOutputStream = new InputOutputStream();
        // After this all System.out.println() statements will come to outContent stream.
        // So, you can normally call
        appInteraction = new AppInteraction(inputOutputStream);
    }

    @AfterEach
    public void clear() {
        outContent = null;
        System.out.close();
        appInteraction = null;
    }

    @Test
    public void testShouldDisplayTheCorrectWelcomeMessage() {
        appInteraction.welcome();
        //Now you have to validate the output
        String expectedOutput = Message.welcome + "\n"; // Notice the \n for new line.

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplaySuccessfulCheckoutMessage() {
        appInteraction.successfulCheckout();

        String expectedOutput = Message.successfulCheckOut + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayCheckoutFailMessage() {
        appInteraction.checkoutFail();

        String expectedOutput = Message.checkOutFail + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplaySuccessfulReturnMessage() {
        appInteraction.successfulReturn();

        String expectedOutput = Message.successfulReturn + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayReturnFailMessage() {
        appInteraction.returnFail();

        String expectedOutput = Message.returnFail + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayInvalidOptionMessage() {
        appInteraction.invalidOption();

        String expectedOutput = Message.invalidOption + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldPrintAList() {
        Book dummyBookOne = new Book(DummyBooks.bookOneName, DummyBooks.bookOneAuthor, DummyBooks.bookOneYearOfPublication);
        Book dummyBookTwo = new Book(DummyBooks.bookTwoName, DummyBooks.bookTwoAuthor, DummyBooks.bookTwoYearOfPublication);
        List<Book> list = asList(dummyBookOne, dummyBookTwo);
        String expectedOutput = ExpectedTestOutputs.bookList;

        appInteraction.printList(list);

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldTakeInputHello() throws IOException {
        System.setIn(new ByteArrayInputStream("Hello".getBytes()));

        String input = appInteraction.readInput();

        assertEquals("Hello", input);
    }

    @Test
    public void testShouldPrintHello() throws IOException {
        appInteraction.print("Hello");

        assertEquals("Hello\n", outContent.toString());
    }
}