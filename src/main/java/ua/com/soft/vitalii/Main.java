package ua.com.soft.vitalii;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
 * + ? властивість,
 * + перевизначені методи input() та print().
 * <p>
 * + 3) Утворити List фруктів і додати до нього 5 різних фруктів і цитрусів.
 * + Видрукувати дані про ті фрукти, колір яких є 'жовтий'.
 * + Посортувати список фруктів за назвою і
 * +     результат вивести у файл
 * - Передбачити перехоплення виняткових ситуацій
 * + Сериалізувати-десериалізувати список у Xml форматі
 * - Написати юніт-тести на методи класів
 */

public class Main {

    public static void main(String[] args) throws IOException {
        final String whatToDo = "Enter fruit name, color, content of vitamin C - optionally for citrus fruits.";
        System.out.println(whatToDo);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        List<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Fruit fruit = new Citrus();
            boolean waitingForData = true;
            while (waitingForData) try {
                fruit.input(consoleReader);
                waitingForData = false;
            } catch (FruitException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                StringBuilder message = new StringBuilder("You should choose from colors:\n");
                for (Color color : Color.values()) {
                    message.append(color);
                    message.append(' ');
                }
                System.err.println(message);
            } catch (NumberFormatException e) {
                System.err.println("You should enter decimal number with dot");
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fruits entered");

        try (BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Fruit fruit : fruits) {
                fruit.print(consoleWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




//        System.out.println(fruits);
//        try (BufferedWriter writerToFile = Files.newBufferedWriter(Paths.get("fruits.txt"), charset)) {
//            for (int i = 0; i < 2; i++) {
//                ua.com.soft.vitalii.Fruit fruit = new ua.com.soft.vitalii.Citrus();
//                System.out.println(readMe);
//                fruit.input(reader);
//                fruits.add(fruit);
//            }
//
//            for (ua.com.soft.vitalii.Fruit fruit : fruits) {
//                fruit.print(writerToFile);
//            }
//        } catch (IOException x) {
//            System.err.format("IOException: %s%n", x);
//        } catch (ua.com.soft.vitalii.FruitException e) {
//            e.printStackTrace();
//        }

//        try {
//            ua.com.soft.vitalii.XMLTools.save(fruits);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<ua.com.soft.vitalii.Fruit> fruits2 = new ArrayList<>();
//
//        try {
//            fruits2.addAll(ua.com.soft.vitalii.XMLTools.read());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

//        Charset charset = Charset.forName("UTF-8");
    }
}
