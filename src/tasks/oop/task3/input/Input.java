package tasks.oop.task3.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    BufferedReader reader;

    public Input() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public double readsNumberFromKeyboard() throws IOException, NumberFormatException {
        String input = reader.readLine();
        double number = 0;
        number = Double.parseDouble(input);
        return number;
    }

    public double readsCodeCommandFromKeyboard() throws IOException {
        return reader.readLine().charAt(0);
    }

    public boolean isStopCommand() throws IOException {
        String userCommand;
        userCommand = reader.readLine();
        return userCommand.equalsIgnoreCase("stop");
    }


}
