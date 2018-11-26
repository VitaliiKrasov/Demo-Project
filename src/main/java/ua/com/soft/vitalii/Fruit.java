package ua.com.soft.vitalii;

import ua.com.soft.vitalii.exceptions.ColorException;
import ua.com.soft.vitalii.exceptions.UnknownFruitException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

import static ua.com.soft.vitalii.tools.Cutter.getArgs;

public class Fruit {
    private String name;
    private Color color;

    public Fruit(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Fruit() {
    }

    public void input(BufferedReader br) throws IOException, ColorException, UnknownFruitException {
        String line = br.readLine().trim();
        String[] args = getArgs(line);
        if (args.length > 2) {
            setName(args[1]);
            try {
                Color color = Color.valueOf(args[2].toUpperCase());
                setColor(color);
            } catch (IllegalArgumentException e) {
                throw new ColorException();
            }
        } else throw new UnknownFruitException("Wrong input data for fruit");
    }

    public void print(BufferedWriter bw) throws IOException {
        String s = this.toString();
        bw.write(s);
        bw.newLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s, name %s, color %s",
                this.getClass().toString().replaceAll("ua.com.soft.vitalii.", ""),
                name, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name) &&
                color == fruit.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
}
