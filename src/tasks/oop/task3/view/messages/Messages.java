package tasks.oop.task3.view.messages;

public enum Messages {

    CONTINUE_OR_STOP("Press Enter to continue or enter stop to exit"),
    ENTER_FIRST_NUMBER("Enter the first number."),
    ENTER_SECOND_NUMBER("Enter the second number."),
    ENTER_COMMAND("Enter the command [+ , -, *, /]"),
    DIVISION_BY_ZERO("Division by zero is not possible!"),
    NUMBER_INPUT_ERROR("You didn't enter a number. Try again! Attempts: "),
    COMMAND_INPUT_ERROR("You entered the wrong command! Attempts: ");

    private String title;

    private Messages(String text) {
        this.title = text;
    }

    public String getMessageText() {
        return title;
    }

}
