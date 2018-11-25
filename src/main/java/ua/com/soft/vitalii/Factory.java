package ua.com.soft.vitalii;

import java.util.Scanner;

public class Factory {
    public static Fruit get(Scanner scanner) {
        String type = scanner.findInLine("apple");
        System.out.println(type);
//        if (input.length == 2) {
//            setName(input[0]);
//            setColor(ua.com.soft.vitalii.Color.valueOf(input[1].toLowerCase()));
//        } else throw new ua.com.soft.vitalii.FruitException("Wrong input");
        return Orchard.Apple_gala.get();
    }
}
