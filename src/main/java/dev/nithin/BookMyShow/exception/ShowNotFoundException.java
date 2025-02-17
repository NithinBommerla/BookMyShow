package dev.nithin.BookMyShow.exception;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException(String s) {
        super(s);
    }
}
