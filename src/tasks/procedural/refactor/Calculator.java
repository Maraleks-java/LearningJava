package tasks.procedural.refactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Move the main logic into static methods
 */

public class Calculator {

    private static final int ENTER_FIRST_NUMBER = 1;
    private static final int ENTER_COMMAND = 2;
    private static final int ENTER_SECOND_NUMBER = 3;
    private static final int PERFORM_CALCULATION = 4;

    private final static char[] MATH_COMMANDS = {'+', '-', '*', '/' };

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        byte attempts;
        String input;
        double firstNumber;
        double secondNumber;
        char userCommand;
        int stage;

        while (true){
            attempts = 3;
            firstNumber = 0;
            secondNumber = 0;
            userCommand = 0;
            stage = ENTER_FIRST_NUMBER;

            displayMessage("Press Enter to continue or enter stop to exit");
            input = reader.readLine();
            if(isStopCommand(input)){
                break;
            }

            while (attempts > 0) {
                try {

                    if(stage == ENTER_FIRST_NUMBER || stage == ENTER_SECOND_NUMBER) {
                        displayMessage("Enter the number.");
                        input = reader.readLine();
                        if(stage == ENTER_FIRST_NUMBER) {
                            firstNumber = Double.parseDouble(input);
                        } else {
                            secondNumber = Double.parseDouble(input);
                        }
                        stage++;
                    }

                    if(stage == ENTER_COMMAND) {
                        displayMessage("Enter the command [+ , -, *, /]");
                        input = reader.readLine();
                        userCommand = input.charAt(0);
                        if(isMathCommand(userCommand)){
                            stage++;
                        } else {
                            attempts--;
                            displayMessage("You entered the wrong command! Attempts: " + attempts);
                        }
                    }

                    if(stage == PERFORM_CALCULATION) {
                        double result = 0;
                        switch (userCommand) {
                            case '+':
                                result = getSumOfNumbers(firstNumber, secondNumber);
                                break;
                            case '-':
                                result = getDifferenceOfNumbers(firstNumber, secondNumber);
                                break;
                            case '*':
                                result = getProductOfNumbers(firstNumber, secondNumber);
                                break;
                            case '/':
                                result = getRatioOfNumbers(firstNumber, secondNumber);
                                break;
                        }
                        displayMessage(String.valueOf(result));
                        break;
                    }

                } catch (NumberFormatException e) {
                    attempts--;
                    displayMessage("You didn't enter a number. Try again! Attempts: " + attempts);
                }
            }
        }
    }

    public static void displayMessage(String message) {
        String formattedDateTime = getFormattedDate(LocalDateTime.now());
        System.out.println(formattedDateTime + " " + message);
    }

    private static String getFormattedDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
    }

    public static boolean isStopCommand(String userCommand) {
        if(userCommand.equalsIgnoreCase("stop")){
            return true;
        }
        return false;
    }

    public static boolean isMathCommand(char userCommand) {
        for (char mathCommand: MATH_COMMANDS) {
            if(userCommand == mathCommand) {
                return true;
            }
        }
        return false;
    }

    public static double getSumOfNumbers(double a, double b) {
        return a+b;
    }

    public static double getDifferenceOfNumbers(double a, double b) {
        return a-b;
    }

    public static double getProductOfNumbers(double a, double b) {
        return a*b;
    }

    public static double getRatioOfNumbers(double a, double b) throws ArithmeticException{
        return a/b;
    }

}
