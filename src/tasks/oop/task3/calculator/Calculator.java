package tasks.oop.task3.calculator;

import tasks.oop.task3.input.Input;
import tasks.oop.task3.view.messages.Messages;
import tasks.oop.task3.view.output.Output;

import java.io.IOException;

/**
 * @author Alexandr Markov
 * @version 1.1
 */

public class Calculator {
    /**
     */
    private static final int NUMBER_OF_CELLS = 3;
    /**
     */
    private static final int STARTING_NUMBER_OF_ATTEMPTS = 3;
    /**
     */
    private final Input input;
    /**
     */
    private final Output output;
    /**
     */
    private static final int INPUT_PROMPT = 0;
    /**
     */
    private static final int ENTER_FIRST_NUMBER = 1;
    /**
     */
    private static final int ENTER_COMMAND = 2;
    /**
     */
    private static final int ENTER_SECOND_NUMBER = 3;
    /**
     */
    private static final int PERFORM_CALCULATION = 4;
    /**
     */
    private static final char[] MATH_COMMANDS = {'+', '-', '*', '/'};
    /**
     */
    private final double[] expression;
    /**
     */
    private int stage;
    /**
     */
    private int attemptCounter;
    /**
     */
    public Calculator() {
        input = new Input();
        output = new Output();
        expression = new double[NUMBER_OF_CELLS];
        attemptCounter = STARTING_NUMBER_OF_ATTEMPTS;
        stage = ENTER_FIRST_NUMBER;
    }
    /**
     * @throws IOException
     */
    public void start() throws IOException {
        while (true) {
            if (attemptCounter == 0) {
                attemptCounter = STARTING_NUMBER_OF_ATTEMPTS;
            }
            output.displayMessage(Messages.CONTINUE_OR_STOP.getMessageText());
            if (input.isStopCommand()) {
                break;
            }
            while (attemptCounter > 0) {
                if (stage == INPUT_PROMPT) {
                    stage = ENTER_FIRST_NUMBER;
                    break;
                }
                try {
                    switch (stage) {
                        case (ENTER_FIRST_NUMBER):
                            output.displayMessage(Messages.ENTER_FIRST_NUMBER.
                                    getMessageText());
                            expression[0] = input.readsNumberFromKeyboard();
                            stage = ENTER_COMMAND;
                            break;
                        case (ENTER_COMMAND):
                            output.displayMessage(Messages.ENTER_COMMAND.
                                    getMessageText());
                            char userCommand = (char) input.
                                    readsCodeCommandFromKeyboard();
                            if (isMathCommand(userCommand)) {
                                expression[1] = (double) userCommand;
                                stage = ENTER_SECOND_NUMBER;
                            } else {
                                attemptCounter--;
                                output.displayMessage(Messages.
                                        COMMAND_INPUT_ERROR.getMessageText()
                                        + attemptCounter);
                            }
                            break;
                        case (ENTER_SECOND_NUMBER):
                            output.displayMessage(Messages.
                                    ENTER_SECOND_NUMBER.getMessageText());
                            expression[2] = input.readsNumberFromKeyboard();
                            stage = PERFORM_CALCULATION;
                            break;
                        case (PERFORM_CALCULATION):
                            stage = INPUT_PROMPT;
                            double result = getResultOfCalculations(expression);
                            output.displayMessage(String.valueOf(result));
                            break;
                        default:
                            // Do something...
                    }
                } catch (NumberFormatException exception) {
                    attemptCounter--;
                    output.displayMessage(Messages.
                            NUMBER_INPUT_ERROR.getMessageText()
                            + attemptCounter);
                }
            }
        }
    }
    /**
     * @param expression
     * @return Calculation result.
     */
    private double getResultOfCalculations(final double[] expression) {
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
            default:
                //Do something
        }
        return result;
    }
    /**
     * @param userCommand
     * @return Returns true if the user's command is in the command array.
     */
    public static boolean isMathCommand(final char userCommand) {
        for (char mathCommand : MATH_COMMANDS) {
            if (userCommand == mathCommand) {
                return true;
            }
        }
        return false;
    }
    /**
     * @param a
     * @param b
     * @return Calculation result
     */
    private double getSumOfNumbers(final double a, final double b) {
        return a + b;
    }
    /**
     * @param a
     * @param b
     * @return Calculation result
     */
    private double getDifferenceOfNumbers(final double a, final double b) {
        return a - b;
    }
    /**
     * @param a
     * @param b
     * @return Calculation result
     */
    private double getProductOfNumbers(final double a, final double b) {
        return a * b;
    }
    /**
     * @param a
     * @param b
     * @return Calculation result
     * @throws ArithmeticException
     */
    private double getRatioOfNumbers(final double a, final double b) throws
            ArithmeticException {
        return a / b;
    }

}

