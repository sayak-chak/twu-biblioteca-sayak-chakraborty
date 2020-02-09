package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InteractionTest {
    ByteArrayOutputStream outContent;
    @BeforeEach
    public void initializeOutputStreams(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.
        // So, you can normally call
    }
    @Test
    public void testShouldDisplayTheCorrectWelcomeMessage(){
        Interaction interaction = new Interaction(); // TODO - inconsistency - can we make up our mind if we are singular or plural.

        interaction.welcome();
        //Now you have to validate the output
        String expectedOutput  = MESSAGE.WELCOME+"\n"; // Notice the \n for new line.

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

}