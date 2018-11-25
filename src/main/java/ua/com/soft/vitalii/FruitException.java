package ua.com.soft.vitalii;

public class FruitException extends Exception {
    public FruitException(String s) {
        System.err.println(s);
    }
}
