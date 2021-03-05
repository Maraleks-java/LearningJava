package tasks.oop.task3.view.output;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Alexandr Markov
 * @version 1.0
 */
public class Output {
    /**
     */
    public Output() {

    }

    /**
     * @param message
     */
    public void displayMessage(final String message) {
        String formattedDateTime = getFormattedDate(LocalDateTime.now());
        System.out.println(formattedDateTime + " " + message);
    }

    private static String getFormattedDate(final LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.
                               ofPattern("yyyy.MM.dd hh:mm:ss"));
    }

}
