package oca.chat.constants;

public class UIConstants {
    public static final String DEFAULT_LAYOUT_WITHOUT_TITLE = "Lirio Chat";
    public static final String DEFAULT_LAYOUT_WITH_TITLE = DEFAULT_LAYOUT_WITHOUT_TITLE + " - ";

    public static final String CLEAR_TEXT = "";
    public static final String MESSAGE = "${message}";
    public static final String USER_NAME = "${userName}";
    public static final String ERROR_MESSAGE = "${error_message}";

    public static final String INFO_NO_WRITER = "Sorry ! You are not connected to the network";

    public static final String ERROR_SENDING_MESSAGE =
        "Sorry! the \"" + MESSAGE + "\" could not be sent";

    public static final String USERS_LINE = USER_NAME + ":\n" + MESSAGE + "\n";
    public static final String SYSTEM_ERROR_LINE = "SYSTEM ERROR:\n<< " + ERROR_MESSAGE + " >>\n";
    public static final String SYSTEM_LINE = "SYSTEM:\n<< " + MESSAGE + " >>\n";
    public static final String ME = USERS_LINE.replace(USER_NAME, "Me");
}
