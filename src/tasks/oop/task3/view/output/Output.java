package tasks.oop.task3.view.output;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @version 1.0
 * @author Alexandr Markov
 */
public class Output {
    /**
     * Default constructor.
     */
    public Output() {

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
     * @param dateTime
     * @return String representation of date and time.
     */
    private static String getFormattedDate(final LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.
                               ofPattern("yyyy.MM.dd hh:mm:ss"));
    }

}
