/*
 * %W% %E% Aleksandr Markov
 */
package tasks.oop.task3.calculator;

import java.io.IOException;

import tasks.oop.task3.input.Input;
import tasks.oop.task3.view.messages.Messages;
import tasks.oop.task3.view.output.Output;

/**
 * @version 1.1
 * @author Alexandr Markov
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
    private Input input;

    /**
     */
    private Output output;

    /**
     */
    private double[] expression;

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
    public void countUntilYouComplete() throws IOException {
        while (true) {
            if (attemptCounter == 0) {
                attemptCounter = STARTING_NUMBER_OF_ATTEMPTS;
            }
            output.displayMessage(Messages.CONTINUE_OR_STOP.getMessageText());
            if (input.isStopCommand()) {
                break;
            }
            while (attemptCounter > 0) {
                readNumber(stage);
                readCommand(stage);
                readNumber(stage);
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
                result = expression[0] + expression[2];
                break;
            case ('-'):
                result = expression[0] - expression[2];
                break;
            case ('*'):
                result = expression[0] * expression[2];
                break;
            case ('/'):
                result = expression[0] / expression[2];
                break;
            default:
                break;
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
     * @param stage
     * @throws IOException
     */
    private void readNumber(final int stage) throws IOException {
        try {
            switch (stage) {
                case (ENTER_FIRST_NUMBER):
                    output.displayMessage(Messages.ENTER_FIRST_NUMBER.
                            getMessageText());
                    expression[0] = input.readOnlyNumbersFromKeyboard();
                    this.stage = ENTER_COMMAND;
                    break;
                case (ENTER_SECOND_NUMBER):
                    output.displayMessage(Messages.
                            ENTER_SECOND_NUMBER.getMessageText());
                    expression[2] = input.readOnlyNumbersFromKeyboard();
                    this.stage = PERFORM_CALCULATION;
                    break;
                default:
            }
        } catch (NumberFormatException exception) {
            attemptCounter--;
            output.displayMessage(Messages.
                    NUMBER_INPUT_ERROR.getMessageText()
                    + attemptCounter);
        }
    }

    /**
     * @param stage
     * @throws IOException
     */
    private void readCommand(final int stage) throws IOException {
        switch (stage) {
            case (ENTER_COMMAND):
                output.displayMessage(Messages.ENTER_COMMAND.
                        getMessageText());
                char userCommand = (char) input.
                        readKeyboardCommandCode();
                if (isMathCommand(userCommand)) {
                    expression[1] = (double) userCommand;
                    this.stage = ENTER_SECOND_NUMBER;
                    break;
                } else {
                    attemptCounter--;
                    output.displayMessage(Messages.
                            COMMAND_INPUT_ERROR.getMessageText()
                            + attemptCounter);
                }
                break;
            case (PERFORM_CALCULATION):
                this.stage = ENTER_FIRST_NUMBER;
                double result = getResultOfCalculations(expression);
                output.displayMessage(String.valueOf(result));
                break;
            default:
                break;
        }
    }
}

