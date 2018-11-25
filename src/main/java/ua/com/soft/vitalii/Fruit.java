package ua.com.soft.vitalii;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class Fruit {
    private String name;
    private Color color;

    public Fruit(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Fruit() {
    }

    public void input(BufferedReader br) throws IOException, FruitException {
        String[] input = br.readLine().trim().split("\\s+");
        if (input.length == 2) {
            setName(input[0]);
            setColor(Color.valueOf(input[1].toUpperCase()));
        } else throw new FruitException("Wrong input");
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
        return String.format("name='%s', color=%s", name, color);
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
