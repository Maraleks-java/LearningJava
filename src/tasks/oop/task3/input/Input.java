package tasks.oop.task3.input;

import tasks.procedural.refactor.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    BufferedReader reader;

    public Input() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public double readsNumberFromKeyboard() throws IOException, NumberFormatException {
        double number = 0;
        String input = reader.readLine();
        number = Double.parseDouble(input);
        return number;
    }

    public double readsCodeCommandFromKeyboard() throws IOException {
        int commandCode = 0;
        char command;
        String input = reader.readLine();
        command = input.charAt(0);
        commandCode = (int)command;
        return (double)commandCode;
    }

    public boolean isStopCommand() throws IOException {
        String userCommand;
        userCommand = reader.readLine();
        if(userCommand.equalsIgnoreCase("stop")){
            return true;
        }
        return false;
    }



}
