package tasks.procedural.refactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Move the main logic into static methods
 */

public class Calculator {

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
        char[] mathCommands = {'+', '-', '*', '/' };
        for (int i = 0; i < mathCommands.length; i++) {
            if(mathCommands[i] == userCommand) {
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

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean processingIsAvailable = true;
        while (processingIsAvailable){
            byte attempts = 3;
            String input;
            double firstNumber = 0;
            double secondNumber = 0;
            char userCommand = 0;
            byte stage = 1;

            System.out.println("Press Enter to continue or type stop to exit");
            input = reader.readLine();
            if(сompletionСheck(input)){
                processingIsAvailable = false;
                break;
            }

            while (attempts > 0) {
                try {

                    if(stage == 1 || stage == 3) {
                        System.out.println("Enter the number.");
                        input = reader.readLine();
                        if(stage == 1) {
                            firstNumber = Double.parseDouble(input);
                        }
                        if(stage == 3) {
                            secondNumber = Double.parseDouble(input);
                        }
                        stage++;
                    }

                    if(stage == 2) {
                        System.out.println( "Enter the command [+ , -, *, /]");
                        input = reader.readLine();
                        userCommand = input.charAt(0);
                        if(Calculator.isMathCommand(userCommand)){
                            stage++;
                        } else {
                            attempts--;
                            System.out.println( "You entered the wrong command! Attempts: " + attempts);
                        }
                    }

                    if(stage == 4) {
                        switch (userCommand) {
                            case '+':
                                System.out.println(getSumOfNumbers(firstNumber, secondNumber));
                                break;
                            case '-':
                                System.out.println(getDifferenceOfNumbers(firstNumber, secondNumber));
                                break;
                            case '*':
                                System.out.println(getProductOfNumbers(firstNumber, secondNumber));
                                break;
                            case '/':
                                System.out.println(getRatioOfNumbers(firstNumber, secondNumber));
                                break;
                        }
                        break;
                    }

                } catch (NumberFormatException e) {
                    attempts--;
                    System.out.println("You didn't enter a number. Try again! Attempts: " + attempts);
                }
            }
        }
    }
}
