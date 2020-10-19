package tasks.procedural.refactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean powerButton = true;
        while (powerButton){
            byte attempts = 3;
            String input;
            double firstNumber = 0;
            double secondNumber = 0;
            char mathematicalProcessing = 'd';
            byte stage = 1;
            while (attempts > 0) {
                if(attempts == 0) {
                    break;
                }
                try {

                    if(stage == 1 || stage == 3) {
                        System.out.println("Enter the number. To exit - enter \"stop\"");
                        input = reader.readLine();
                        if(input.equalsIgnoreCase("stop")){
                            powerButton = false;
                            break;
                        }
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
                        char[] commands = {'+', '-', '*', '/' };
                        for (int i = 0; i < commands.length; i++) {
                            if(commands[i] == input.charAt(0)) {
                                mathematicalProcessing = commands[i];
                                stage++;
                                break;
                            }
                        }
                        if(mathematicalProcessing == 'd') {
                            attempts--;
                            System.out.println( "You entered the wrong command! Attempts: " + attempts);
                        }
                    }

                    if(stage > 3) {
                        if(mathematicalProcessing == '+') {
                            System.out.println(firstNumber + secondNumber);
                            break;
                        }
                        if(mathematicalProcessing == '-') {
                            System.out.println(firstNumber - secondNumber);
                            break;
                        }
                        if(mathematicalProcessing == '*') {
                            System.out.println(firstNumber * secondNumber);
                            break;
                        }
                        if(mathematicalProcessing == '/') {
                            System.out.println(firstNumber / secondNumber);
                            break;
                        }
                    }

                } catch (NumberFormatException e) {
                    attempts--;
                    System.out.println("You didn't enter a number. Try again! Attempts: " + attempts);
                }
            }
        }
    }
}
