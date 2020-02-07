package com.twu.biblioteca;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class InteractionsTest {
    @Test
    public void testShouldDisplayTheCorrectWelcomeMessage(){
        Interactions interaction = new Interactions(); // TODO - inconsistency - can we make up our mind if we are singular or plural.

        assertEquals(MESSAGE.welcome, interaction.welcome());
    }

}