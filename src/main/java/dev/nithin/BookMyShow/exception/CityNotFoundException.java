package dev.nithin.BookMyShow.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException() {

    }

    public CityNotFoundException(String s) {
        super(s);
    }
}
