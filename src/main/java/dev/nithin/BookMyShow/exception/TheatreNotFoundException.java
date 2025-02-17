package dev.nithin.BookMyShow.exception;

public class TheatreNotFoundException extends RuntimeException {
    public TheatreNotFoundException(String s) {
        super(s);
    }
}
