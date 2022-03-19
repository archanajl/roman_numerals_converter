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
        System.setIn(new ByteArrayInputStream("I\n".getBytes()));
        MyMainClass.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("You converted the Roman Numeral I to the number 1.", outputLines[1]);
    }

    @Test
    public void checkconvertInvalidNumeral(){
        System.setIn(new ByteArrayInputStream("L\n".getBytes()));
        MyMainClass.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("The Roman Numeral L, you entered is invalid.", outputLines[1]);
    }

    @Test
    public void checkconvertEmptyInput(){
        System.setIn(new ByteArrayInputStream("\n".getBytes()));
        MyMainClass.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("No Numeral entered.", outputLines[1]);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(stdin);
        System.setOut(stdout);
    }
}