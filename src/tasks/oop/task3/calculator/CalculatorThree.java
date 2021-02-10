package tasks.oop.task3.calculator;

import tasks.oop.task3.input.Input;
import tasks.oop.task3.view.messages.Messages;
import tasks.oop.task3.view.output.Output;

import java.io.IOException;

public class CalculatorThree {

    private Input input;

    private Output output;

    private static final int OUTPUTTING_THE_RESULT = 0;
    private static final int ENTER_FIRST_NUMBER = 1;
    private static final int ENTER_COMMAND = 2;
    private static final int ENTER_SECOND_NUMBER = 3;
    private static final int PERFORM_CALCULATION = 4;

    private static final char[] MATH_COMMANDS = {'+', '-', '*', '/'};

    private double[] expression;

    private int stage;

    private int attempts;

    public CalculatorThree() {
        input = new Input();
        output = new Output();
        expression = new double[3];
        attempts = 3;
        stage = ENTER_FIRST_NUMBER;
    }

    public void start() throws IOException {
        while (true) {
            if(attempts == 0) {
                attempts = 3;
            }
            output.displayMessage(Messages.CONTINUE_OR_STOP.getMessageText());
            if (input.isStopCommand()) {
                break;
            }
            while (attempts > 0) {
                if(stage == OUTPUTTING_THE_RESULT) {
                    stage = ENTER_FIRST_NUMBER;
                    break;
                }
                try {
                    switch (stage) {
                        case (ENTER_FIRST_NUMBER):
                            output.displayMessage(Messages.ENTER_FIRST_NUMBER.getMessageText());
                            expression[0] = input.readsNumberFromKeyboard();
                            stage = ENTER_COMMAND;
                            break;
                        case (ENTER_COMMAND):
                            output.displayMessage(Messages.ENTER_COMMAND.getMessageText());
                            char userCommand = (char) input.readsCodeCommandFromKeyboard();
                            if (isMathCommand(userCommand)) {
                                expression[1] = (double) userCommand;
                                stage = ENTER_SECOND_NUMBER;
                            } else {
                                attempts--;
                                output.displayMessage(Messages.COMMAND_INPUT_ERROR.getMessageText() + attempts);
                            }
                            break;
                        case (ENTER_SECOND_NUMBER):
                            output.displayMessage(Messages.ENTER_SECOND_NUMBER.getMessageText());
                            expression[2] = input.readsNumberFromKeyboard();
                            stage = PERFORM_CALCULATION;
                            break;
                        case (PERFORM_CALCULATION):
                            stage = OUTPUTTING_THE_RESULT;
                            double result = getResultOfCalculations(expression);
                            output.displayMessage(String.valueOf(result));
                            break;
                    }
                } catch (NumberFormatException exception) {
                    attempts--;
                    output.displayMessage(Messages.NUMBER_INPUT_ERROR.getMessageText() + attempts);
                }
            }
        }
    }

    private double getResultOfCalculations(double[] expression) {
        double result = 0;
        switch ((char) expression[1]) {
            case ('+'):
                result = getSumOfNumbers(expression[0], expression[2]);
                break;
            case ('-'):
                result = getDifferenceOfNumbers(expression[0], expression[2]);
                break;
            case ('*'):
                result = getProductOfNumbers(expression[0], expression[2]);
                break;
            case ('/'):
                result = getRatioOfNumbers(expression[0], expression[2]);
                break;
        }
        return result;
    }

    public static boolean isMathCommand(char userCommand) {
        for (char mathCommand: MATH_COMMANDS) {
            if(userCommand == mathCommand) {
                return true;
            }
        }
        return false;
    }

    private double getSumOfNumbers(double a, double b) {
        return a+b;
    }

    private double getDifferenceOfNumbers(double a, double b) {
        return a-b;
    }

    private double getProductOfNumbers(double a, double b) {
        return a*b;
    }

    private double getRatioOfNumbers(double a, double b) throws ArithmeticException{
        return a/b;
    }

}

