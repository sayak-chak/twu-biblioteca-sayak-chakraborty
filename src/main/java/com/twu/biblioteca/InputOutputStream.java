package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Why no tests
public class InputOutputStream {

    String input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return input.readLine();
    }

    //TODO: no This
    void output(String printThis) {
        System.out.println(printThis);
    }
}
