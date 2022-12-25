package dev.lupluv.challenges.util;

public class DisableReason {

    public static DisableReason COMMAND_NOT_FOUND(String command){
        return new DisableReason("A command could not be found. [" + command  + "]");
    }

    private String message;

    public DisableReason(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
