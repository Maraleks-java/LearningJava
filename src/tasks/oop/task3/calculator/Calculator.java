/*
 * %W% %E% Aleksandr Markov
 */
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
     * The constant determines the size of the expression,
     * taking into account the signs
     */
    private static final int NUMBER_OF_CELLS = 3;

    /**
     * The constant determines the number of acceptable errors when entering
     */
    private static final int STARTING_NUMBER_OF_ATTEMPTS = 3;

    /**
     * The constant stores the calculation step in numerical representation
     */
    private static final int ENTER_FIRST_NUMBER = 1;

    /**
     * The constant stores the calculation step in numerical representation
     */
    private static final int ENTER_COMMAND = 2;

    /**
     * The constant stores the calculation step in numerical representation
     */
    private static final int ENTER_SECOND_NUMBER = 3;

    /**
     * The constant stores the calculation step in numerical representation
     */
    private static final int PERFORM_CALCULATION = 4;

    /**
     * The array stores valid math commands
     */
    private static final char[] MATH_COMMANDS = {'+', '-', '*', '/'};

    /**
     * A reference to an object that is responsible for the input method
     */
    private final Input input;

    /**
     * Reference to the object responsible for the output method
     */
    private final Output output;

    /**
     * An array storing a ready-made expression
     */
    private final double[] expression;

    /**
     * Stores the current stage of the calculator
     */
    private int stage;

    /**
     * Determines how many correct input attempts are left before restarting the calculator
     */
    private int attemptCounter;

    /**
     * Default constructor
     */
    public Calculator() {
        input = new Input();
        output = new Output();
        expression = new double[NUMBER_OF_CELLS];
        attemptCounter = STARTING_NUMBER_OF_ATTEMPTS;
        stage = ENTER_FIRST_NUMBER;
    }

    /**
     * @throws IOException If passed an empty object
     *                     Application launch method.
     */
    public void process() throws IOException {
        while (true) {
            output.displayMessage(Messages.CONTINUE_OR_STOP.getMessageText());
            if (input.isStopCommand())
                break;
            while (attemptCounter > -1) {
                if (attemptCounter == 0) {
                    attemptCounter = STARTING_NUMBER_OF_ATTEMPTS;
                    break;
                }
                readNumber(stage);
                if (stage == ENTER_COMMAND) {
                    readCommand(stage);
                } else if (stage == PERFORM_CALCULATION) {
                    double result = getCalculationResult(expression);
                    output.displayMessage(String.valueOf(result));
                    break;
                }
            }
        }
    }

    /**
     * @param userCommand The command entered by the user
     * @return Returns true if the user's command is in the command array.
     */
    private static boolean isMathCommand(final char userCommand) {
        for (char mathCommand : MATH_COMMANDS) {
            if (userCommand == mathCommand) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param stage takes the calculation step
     * @throws IOException If passed an empty object
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
                    break;
            }
        } catch (NumberFormatException exception) {
            attemptCounter--;
            output.displayMessage(Messages.
                    NUMBER_INPUT_ERROR.getMessageText()
                    + attemptCounter);
        }
    }

    /**
     * @param stage takes the calculation step
     * @throws IOException If passed an empty object
     */
    private void readCommand(final int stage) throws IOException {
        output.displayMessage(Messages.ENTER_COMMAND.
                getMessageText());
        char userCommand = (char) input.
                readKeyboardCommandCode();
        if (isMathCommand(userCommand)) {
            expression[1] = userCommand;
            this.stage = ENTER_SECOND_NUMBER;
        } else {
            attemptCounter--;
            output.displayMessage(Messages.
                    COMMAND_INPUT_ERROR.getMessageText()
                    + attemptCounter);
        }
    }

    /**
     * @param expression Ready expression
     * @return Calculation result.
     */
    private double getCalculationResult(final double[] expression) {
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
        stage = ENTER_FIRST_NUMBER;
        return result;
    }
}

