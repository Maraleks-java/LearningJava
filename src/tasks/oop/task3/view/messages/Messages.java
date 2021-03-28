/*
 * %W% %E% Aleksandr Markov
 */
package tasks.oop.task3.view.messages;

/**
 * "enam" with text messages
 */
public enum Messages {

    /**
     * Text message.
     */
    CONTINUE_OR_STOP("Press Enter to continue or enter stop to exit"),
    /**
     * Text message.
     */
    ENTER_FIRST_NUMBER("Enter the first number."),
    /**
     * Text message.
     */
    ENTER_SECOND_NUMBER("Enter the second number."),
    /**
     * Text message.
     */
    ENTER_COMMAND("Enter the command [+ , -, *, /]"),
    /**
     * Text message.
     */
    NUMBER_INPUT_ERROR("You didn't enter a number. Try again! Attempts: "),
    /**
     * Text message.
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
