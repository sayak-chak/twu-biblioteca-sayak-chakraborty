package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthenticatorTest {
    private Authenticator authenticator;

    @BeforeEach
    public void initialize() {
        authenticator = new Authenticator();
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

}