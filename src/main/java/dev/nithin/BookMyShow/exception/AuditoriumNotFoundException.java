package dev.nithin.BookMyShow.exception;

public class AuditoriumNotFoundException extends RuntimeException {
    public AuditoriumNotFoundException(String message) {
        super(message);
    }
}
