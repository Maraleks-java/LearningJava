package tasks.oop.task3.view.output;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Output {

    public Output(){

    }

    public void displayMessage(String message) {
        String formattedDateTime = getFormattedDate(LocalDateTime.now());
        System.out.println(formattedDateTime + " " + message);
    }

    private static String getFormattedDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
    }

}
