package tasks.oop.task3.view.messages;

/**
 * "enam" with text messages
 */
public enum Messages {

    /**
     * Object with a text message.
     */
    CONTINUE_OR_STOP("Press Enter to continue or enter stop to exit"),
    /**
     * Object with a text message.
     */
    ENTER_FIRST_NUMBER("Enter the first number."),
    /**
     * Object with a text message.
     */
    ENTER_SECOND_NUMBER("Enter the second number."),
    /**
     * Object with a text message.
     */
    ENTER_COMMAND("Enter the command [+ , -, *, /]"),
    /**
     * Object with a text message.
     */
    NUMBER_INPUT_ERROR("You didn't enter a number. Try again! Attempts: "),
    /**
     * Object with a text message.
     */
    COMMAND_INPUT_ERROR("You entered the wrong command! Attempts: ");

    /**
     * The constant stores the message text corresponding to the name
     */
    private final String title;

    /**
     * @param text message
     * Default constructor.
     */
    Messages(final String text) {
        this.title = text;
    }

    /**
     * @return Message text
     * Method for accessing the corresponding field.
     */
    public String getMessageText() {
        return title;
    }

}
