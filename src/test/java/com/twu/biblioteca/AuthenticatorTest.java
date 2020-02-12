package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AuthenticatorTest {
    AppInteraction appInteraction;
    private Authenticator authenticator;

    @BeforeEach
    public void initialize() {
        appInteraction = mock(AppInteraction.class);
        authenticator = new Authenticator(appInteraction);
    }

    @Test
    public void testReturnsTrueifItsAValiduser() {
        assertTrue(authenticator.isValidUser(DummyUser.libraryNumber, DummyUser.password));
    }

    @Test
    public void testReturnsFalseIfItGetsInvalidPassword() {
        assertFalse(authenticator.isValidUser(DummyUser.libraryNumber, DummyUser.invalidPassword));
    }

    @Test
    public void testReturnsFalseIfItGetsInvalidUserId() {
        assertFalse(authenticator.isValidUser(DummyUser.invalidLibraryNumber, DummyUser.password));
    }

    @Test
    public void testPrintsUserDetailsIfItsAvalidAccount() {
        authenticator.isValidUser(DummyUser.libraryNumber, DummyUser.password);

        verify(appInteraction, times(1)).print(DummyUser.information);
    }

    @Test
    public void testShouldNotPrintUserDetailsIfItsAvalidAccount() {
        authenticator.isValidUser(DummyUser.invalidLibraryNumber, DummyUser.password);

        verify(appInteraction, times(0)).print(DummyUser.information);
    }

}