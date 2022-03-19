package com.romannumerals.inputconsole;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class InputConsoleTest {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private final InputStream stdin = System.in;

    @BeforeEach
    public void setUp() {
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
    }

    @Test
    public void checkconvertNumeral(){
        System.setIn(new ByteArrayInputStream("I".getBytes()));
        MyMainClass.main(new String[0]);
        String outputText = byteArrayOutputStream.toString();
        String key = "number";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        Assertions.assertEquals("I", output);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(stdin);
        System.setOut(stdout);
    }
}