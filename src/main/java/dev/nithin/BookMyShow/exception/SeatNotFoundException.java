package dev.nithin.BookMyShow.exception;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(String s) {
        super(s);
    }
}
