package ua.com.soft.vitalii.exceptions;

import ua.com.soft.vitalii.Color;

public class ColorException extends Exception {
    public ColorException() {
        StringBuilder message = new StringBuilder("You should choose from colors:\n");
        for (Color color : Color.values()) {
            message.append(color);
            message.append(' ');
        }
        System.err.println(message);
    }
}
