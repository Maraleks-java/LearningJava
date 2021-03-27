/*
 * %W% %E% Aleksandr Markov
 *
 */
package tasks.oop.task3.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @version 1.0
 * @author Alexandr Markov
 * The "Input" class describes how to enter information.
 * This version implements a method of entering only numbers from the keyboard,
 * or only characters
 */
public class Input {

    /**
     * Field for storing the object responsible
     * for reading the stream from the keyboard
     */
    private final BufferedReader reader;

    /**
     * Default constructor.
     * Creates an object of the "reader" class when called
     */
    public Input() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * @return The number entered by the user.
     * @throws IOException If passed an empty object
     * @throws NumberFormatException if your input format is invalid
     * The method reads only number from the keyboard.
     */
    public double readOnlyNumbersFromKeyboard() throws IOException,
            NumberFormatException {
        String input = reader.readLine();
        double number;
        number = Double.parseDouble(input);
        return number;
    }

    /**
     * @return Returns the code of the first custom character.
     * @throws IOException If passed an empty object.
     * The method reads the first character in the string and returns its code
     */
    public double readKeyboardCommandCode() throws IOException {
        return reader.readLine().charAt(0);
    }

    /**
     * @return boolean
     * in a case insensitive manner.
     * @throws IOException
     * The method asks to enter a code word regardless of its case.
     * Returns true if it was entered correctly.
     */
    public boolean isStopCommand() throws IOException {
        String userCommand;
        userCommand = reader.readLine();
        return userCommand.equalsIgnoreCase("stop");
    }


}
