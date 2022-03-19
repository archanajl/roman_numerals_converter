package com.romannumerals.inputconsole;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputConsole {
    private Scanner scanner;
    private PrintStream printStream;

    public InputConsole(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public void convertNumeral() {
        printStream.println("Enter roman numeral");
        String input_numeral = scanner.nextLine();
        printStream.println("You converted the Roman Numeral " + input_numeral + " to the number " + convertRomanNumeralstoNumbers(input_numeral));
    }

    public String convertRomanNumeralstoNumbers(String roman_numeral){
        // code to convert the roman numerals
        return roman_numeral;
    }

}
