package com.romannumerals.inputconsole;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.HashMap;

public class InputConsole {

    private Scanner scanner;
    private PrintStream printStream;
    private HashMap<String, Integer> numeralMap = new HashMap<>();
    //numeralMap stores the value pairs of the roman numerals and numbers

    public InputConsole(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
        this.numeralMap.put("I",1);
        this.numeralMap.put("II",2);
        this.numeralMap.put("III",3);
        this.numeralMap.put("IV",4);
        this.numeralMap.put("V",5);
        this.numeralMap.put("VI",6);
        this.numeralMap.put("VII",7);
        this.numeralMap.put("VIII",8);
        this.numeralMap.put("IX",9);
        this.numeralMap.put("X",10);
    }

    public void convertNumeral() {
        try {
            printStream.println("Enter roman numeral:(Please enter 'exit' once you are done.)");
            while (scanner.hasNextLine()){
                String input_numeral = scanner.nextLine();
                if (input_numeral.equalsIgnoreCase("exit")){
                    // exit the program
                    printStream.println("Hope you enjoyed our conversion program.");
                    scanner.close();
                }
                else if (input_numeral.trim().equals("")) {
                    // No numerals entered
                    printStream.println("No Numeral entered. Please enter a valid Roman Numeral or 'exit' to quit.");
                } else if (this.numeralMap.containsKey(input_numeral.trim())) {
                    // Valid numeral entered
                    printStream.println("You converted the Roman Numeral "
                            + input_numeral.trim() + " to the number "
                            + this.numeralMap.get(input_numeral.trim()).toString() + ". Please enter another roman numeral or 'exit' to quit.");
                } else {
                    // Invalid numeral entered
                    printStream.println("The Roman Numeral "
                            + input_numeral.trim() + ", you entered is invalid. Please enter a valid Roman Numeral or 'exit' to quit.");
                }
            }
            if(scanner != null) {
                scanner.close();
            }
        }catch (Exception e){
            printStream.println(e.getMessage());
        }
    }
}

