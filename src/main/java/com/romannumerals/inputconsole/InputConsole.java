package com.romannumerals.inputconsole;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;

public class InputConsole {

    private Scanner scanner;
    private PrintStream printStream;
    private HashMap<Character, Integer> numeralMap = new HashMap<>();
    //numeralMap stores the value pairs of the roman numerals and numbers

    public InputConsole(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
        this.numeralMap.put('I', 1);
        this.numeralMap.put('V', 5);
        this.numeralMap.put('X', 10);
        this.numeralMap.put('L', 50);
        this.numeralMap.put('C', 100);
        this.numeralMap.put('D', 500);
        this.numeralMap.put('M', 1000);
    }

    public void checkValidNumeral() {
        try {
            printStream.println("Enter roman numeral:(Please enter 'exit' once you are done.)");
            while (scanner.hasNextLine()) {
                String input_numeral = scanner.nextLine().trim().toUpperCase();
                if (input_numeral.equalsIgnoreCase("exit")) {
                    // exit the program
                    printStream.println("Hope you enjoyed our conversion program.");
                    scanner.close();
                } else if (input_numeral.equals("")) {
                    // No numerals entered
                    printStream.println("No Numeral entered. Please enter a valid Roman Numeral or 'exit' to quit.");
                } else if (checkIfRoman(input_numeral)) {
                    // Valid numeral entered
                    printStream.println("You converted the Roman Numeral "
                            + input_numeral + " to the number "
                            + convertRoman(input_numeral) + ". Please enter another roman numeral or 'exit' to quit.");
                } else {
                    // Invalid numeral entered
                    printStream.println("The Roman Numeral "
                            + input_numeral + ", you entered is invalid (should include only I,V,X,L,C,D & M). Please enter a valid Roman Numeral or 'exit' to quit.");
                }
            }
            if (scanner != null) {
                scanner.close();
            }
        } catch (Exception e) {
            printStream.println(e.getMessage());
        }
    }

    public boolean checkIfRoman(String input_roman_numeral) {
        // Check whether all characters exist in the numeral map
        List<Character> roman_numeral_list = input_roman_numeral.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList());
        return (this.numeralMap.keySet().containsAll(roman_numeral_list));
    }

    public int convertRoman(String input_roman_numeral) {
        int result_number = 0;
        int present_value = 0;
        int roman_numeral_size = input_roman_numeral.length();

        for (int position= 0; position < roman_numeral_size; position++){
            present_value = this.numeralMap.get(input_roman_numeral.charAt(position));
            if (position + 1 < roman_numeral_size){
                int next_value = this.numeralMap.get(input_roman_numeral.charAt(position+1));
                if (present_value >= next_value){
                     result_number += present_value;
                }else{
                    result_number = result_number + next_value - present_value;
                    position++;
                }
            }else{
                result_number += present_value;
            }
        }
        return result_number;

    }
}
