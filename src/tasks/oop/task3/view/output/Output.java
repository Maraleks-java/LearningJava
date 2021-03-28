/*
 * %W% %E% Aleksandr Markov
 */
package tasks.oop.task3.view.output;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @version 1.0
 * @author Alexandr Markov
 * The Output class contains methods for outputting any text information.
 * In the current version, only output to the screen is implemented.
 */
public class Output {

    /**
     * Default constructor.
     */
    public Output() {
        // If the constructor is declared,
        // but does not have a body, the check asks to write a nested comment.
    }

    /**
     * @param message
     * The method accepts the text of the message.
     * Sets the date and time of the output and prints to the console.
     */
    public void displayMessage(final String message) {
        String formattedDateTime = getFormattedDate(LocalDateTime.now());
        System.out.println(formattedDateTime + " " + message);
    }

    /**
     * @param dateTime object LocalDateTime
     * @return String representation of date and time.
     * The method determines the format of the date and time
     */
    private static String getFormattedDate(final LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.
                               ofPattern("yyyy.MM.dd hh:mm:ss"));
    }

}
