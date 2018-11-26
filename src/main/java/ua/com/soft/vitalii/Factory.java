package ua.com.soft.vitalii;

import ua.com.soft.vitalii.exceptions.ColorException;
import ua.com.soft.vitalii.exceptions.UnknownFruitException;

import java.io.BufferedReader;
import java.io.IOException;

public class Factory {
    public static Fruit get(BufferedReader br) throws IOException, ColorException, UnknownFruitException {
        br.mark(200);
        String line = br.readLine().trim();
        if (line.length() < 30 && !line.contains(" ")) {
            try {
                return Orchard.valueOf(line).get();
            } catch (EnumConstantNotPresentException e) {
                e.printStackTrace();
                throw new UnknownFruitException("The name of the fruit is not in list");
            }
        }

        boolean isFruit = line.contains("Fruit");
        boolean isCitrus = line.contains("Citrus");

        Fruit result;
        if (isFruit) {
            result = new Fruit();
        } else if (isCitrus) {
            result = new Citrus();
        } else throw new UnknownFruitException("Fruit class is not defined");
        br.reset();
        result.input(br);
        if (result == null) throw new UnknownFruitException("null");
        return result;
    }
}
