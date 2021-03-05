package tasks.oop.task3.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    /**
     */
    private BufferedReader reader;
    /**
     */
    public Input() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * @return The number entered by the user.
     * @throws IOException
     * @throws NumberFormatException
     */
    public double readsNumberFromKeyboard() throws
            IOException, NumberFormatException {
        String input = reader.readLine();
        double number = 0;
        number = Double.parseDouble(input);
        return number;
    }

    /**
     * @return Returns the code of the first custom character.
     * @throws IOException
     */
    public double readsCodeCommandFromKeyboard() throws IOException {
        return reader.readLine().charAt(0);
    }

    /**
     * @return Returns true if the user entered the word "stop"
     * in a case insensitive manner.
     * @throws IOException
     */
    public boolean isStopCommand() throws IOException {
        String userCommand;
        userCommand = reader.readLine();
        return userCommand.equalsIgnoreCase("stop");
    }


}
