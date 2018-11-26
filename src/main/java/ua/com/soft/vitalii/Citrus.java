package ua.com.soft.vitalii;

import ua.com.soft.vitalii.exceptions.ColorException;
import ua.com.soft.vitalii.exceptions.UnknownFruitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import static ua.com.soft.vitalii.tools.Cutter.getArgs;

public class Citrus extends Fruit {
    private double containsViataminC;

    public Citrus(String name, Color color, double vitaminC) {
        super(name, color);
        this.containsViataminC = vitaminC;
    }

    public Citrus() {
    }

    @Override
    public void input(BufferedReader br) throws IOException, ColorException, UnknownFruitException {
        String line = br.readLine().trim();
        String[] args = getArgs(line);
        if (args.length > 3) {
            setName(args[1]);
            try {
                Color color = Color.valueOf(args[2].toUpperCase());
                setColor(color);
                setContainsViataminC(Double.parseDouble(args[3]));
            } catch (IllegalArgumentException e) {
                throw new ColorException();
            }
        } else throw new UnknownFruitException("Wrong input data for fruit");
    }

    @Override
    public String toString() {
        return String.format("%s, contains %.1fmg vitamin C", super.toString(), containsViataminC);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citrus)) return false;
        if (!super.equals(o)) return false;
        Citrus citrus = (Citrus) o;
        return containsViataminC == citrus.containsViataminC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), containsViataminC);
    }

    public void setContainsViataminC(double containsViataminC) {
        this.containsViataminC = containsViataminC;
    }

    public double getContainsViataminC() {
        return containsViataminC;
    }
}
