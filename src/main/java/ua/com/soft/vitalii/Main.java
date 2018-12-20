package ua.com.soft.vitalii;

import ua.com.soft.vitalii.exceptions.ColorException;
import ua.com.soft.vitalii.exceptions.UnknownFruitException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ua.com.soft.vitalii.tools.Sorter.getByColor;
import static ua.com.soft.vitalii.tools.Sorter.sortByName;
import static ua.com.soft.vitalii.tools.XMLTools.extract;
import static ua.com.soft.vitalii.tools.XMLTools.save;

/**
 * + 1) Утворити клас Фрукт, який містить:
 * + поля назва та колір,
 * + визначити конструктор з параметрами,
 * + методи input() та print(), для зчитування даних з консолі та виведення даних на консоль,
 * + а також перевантажити варіанти введення-виведення з файлу.
 * + властивості для полів,
 * + перевизначити метод toString().
 * <p>
 * + 2) Утворити похідний від нього клас Цитрус, який має:
 * + поле - вміст вітаміну С в грамах,
 * + конструктор з параметрами,
 * + властивість,
 * + перевизначені методи input() та print().
 * <p>
 * + 3) Утворити List фруктів і додати до нього 5 різних фруктів і цитрусів.
 * + Видрукувати дані про ті фрукти, колір яких є 'жовтий'.
 * + Посортувати список фруктів за назвою і
 * +     результат вивести у файл
 * + Передбачити перехоплення виняткових ситуацій
 * + Сериалізувати-десериалізувати список у Xml форматі
 * + Написати юніт-тести на методи класів
 */

public class Main {

    public static void main(String[] args) {
        final String whatToDo = "Enter fruit data: class, name, color, content of vitamin C - optionally for citrus fruits.";

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        List<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println(whatToDo);
            boolean waitingForData = true;
            while (waitingForData) try {
                Fruit fruit = Factory.get(consoleReader);
                fruits.add(fruit);
                waitingForData = false;
                System.out.println(fruit.toString() + " added to list\n");
            } catch (UnknownFruitException e) {
                e.printStackTrace();
            } catch (ColorException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("You should enter decimal number with dot");
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(fruits.size() + " fruits entered\n");

        List<Fruit> yellowFruit = getByColor(fruits, Color.YELLOW);
        System.out.println(yellowFruit.size() + " fruits are yellow");
        try (BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Fruit fruit : yellowFruit) {
                fruit.print(consoleWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sortByName(fruits);
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writerToFile = Files.newBufferedWriter(Paths.get("fruits.txt"), charset)) {
            for (Fruit fruit : fruits) {
                fruit.print(writerToFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            save(fruits);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Fruit> fruits2 = new ArrayList<>();

        try {
            fruits2.addAll(extract());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
