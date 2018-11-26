package ua.com.soft.vitalii.exceptions;

public class UnknownFruitException extends Throwable {
    public UnknownFruitException(String s) {
        System.err.println(s);
    }
}
