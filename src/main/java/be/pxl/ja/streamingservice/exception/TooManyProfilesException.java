package be.pxl.ja.streamingservice.exception;

public class TooManyProfilesException extends RuntimeException {
    public TooManyProfilesException() {
        super("You reached the maximum number of profiles.");
    }
}
