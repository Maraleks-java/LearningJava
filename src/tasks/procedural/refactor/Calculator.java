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

    private final static char[] MATH_COMMANDS = {'+', '-', '*', '/' };

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

    public static boolean isMathCommand(char userCommand) {
        for (int mathCommand: MATH_COMMANDS) {
            if(userCommand == mathCommand) {
                return true;
            }
        }
        return false;
    }

    public static boolean сompletionСheck(String userCommand) {
        if(userCommand.equalsIgnoreCase("stop")){
            return true;
        }
        return false;
    }

    public static void message(String info) {
        System.out.print(getFormattedDate(LocalDateTime.now()));
        System.out.println(" " + info);
    }

    private static String getFormattedDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int ENTER_FIRST_NUMBER = 1;
        final int ENTER_COMMAND = 2;
        final int ENTER_SECOND_NUMBER = 3;
        final int PERFORM_CALCULATION = 4;

        byte attempts;
        String input;
        double firstNumber;
        double secondNumber;
        char userCommand;
        byte stage;

        boolean processingIsAvailable = true;
        while (processingIsAvailable){
            attempts = 3;
            firstNumber = 0;
            secondNumber = 0;
            userCommand = 0;
            stage = 1;

            message("Press Enter to continue or type stop to exit");
            input = reader.readLine();
            if(сompletionСheck(input)){
                processingIsAvailable = false;
                break;
            }

            while (attempts > 0) {
                try {

                    if(stage == ENTER_FIRST_NUMBER || stage == ENTER_SECOND_NUMBER) {
                        message("Enter the number.");
                        input = reader.readLine();
                        if(stage == ENTER_FIRST_NUMBER) {
                            firstNumber = Double.parseDouble(input);
                        } else {
                            secondNumber = Double.parseDouble(input);
                        }
                        stage++;
                    }

                    if(stage == ENTER_COMMAND) {
                        message("Enter the command [+ , -, *, /]");
                        input = reader.readLine();
                        userCommand = input.charAt(0);
                        if(Calculator.isMathCommand(userCommand)){
                            stage++;
                        } else {
                            attempts--;
                            message("You entered the wrong command! Attempts: " + attempts);
                        }
                    }

                    if(stage == PERFORM_CALCULATION) {
                        switch (userCommand) {
                            case '+':
                                message(String.valueOf(getSumOfNumbers(firstNumber, secondNumber)));
                                break;
                            case '-':
                                message(String.valueOf(getDifferenceOfNumbers(firstNumber, secondNumber)));
                                break;
                            case '*':
                                message(String.valueOf(getProductOfNumbers(firstNumber, secondNumber)));
                                break;
                            case '/':
                                message(String.valueOf(getRatioOfNumbers(firstNumber, secondNumber)));
                                break;
                        }
                        break;
                    }

                } catch (NumberFormatException e) {
                    attempts--;
                    message("You didn't enter a number. Try again! Attempts: " + attempts);
                }
            }
        }
    }
}
