# roman_numerals_converter

## Goal of the application
 This console application 'roman_numerals_converter' receives the roman numeral as input and provides the equivalent number. 
 
## Key Features of the application
 The application provies the following additional features:
 
 It allows the user to enter multiple times until he enters 'exit' to quit the application. 
 If the user misses to enter any value, it prompts the user to enter. 
 If the user enters anything other I,V,X,L,C,D,M (both caps and small) , it prompts the user to enter a valid numeral.

## Technologies Used
    Java
    maven
    JUnit 5

## How to run the application and tests

  To compile the project and generate target folder:
  ```bash
    mvn compile
   ```
    
  To build the project:
  ```bash
    mvn clean install
  ```
    
  To package the project:
  ```bash
    mvn package
  ```

  To run the project:
  ```bash
    mvn exec:java -Dexec.mainClass=com.romannumerals.inputconsole.MyMainClass
  ```

  To run the tests, use the following command:
```bash
    mvn test
```

## Ideas on how the application could be improved further

 The application is able to identify invalid numerals only when the letters other than I,V,X,L,C,D,M are missing. 
 But there are cases where the position of the letters makes the numeral invalid. For example DMX is an invalid numeral though it has valid letters.
 These numerals have to be handled and notified as invalid numerals,
      
      
