package ua.com.soft.vitalii;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
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
        BufferedWriter writerToConsole = new BufferedWriter(new OutputStreamWriter(System.out));
        Charset charset = Charset.forName("UTF-8");
        Scanner scanner = new Scanner(System.in);
        Fruit fruit = Factory.get(scanner);
        System.out.println(fruit.getColor());
        fruit.print(writerToConsole);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        final String README = "Enter the name of the fruit, color, optionally for citrus fruits - the content of vitamin C.";
//        System.out.println(README);

//        List<ua.com.soft.vitalii.Fruit> fruits = new LinkedList<ua.com.soft.vitalii.Fruit>();
//        fruits.add(new ua.com.soft.vitalii.Fruit("Apple", ua.com.soft.vitalii.Color.yellow));
//        fruits.add(new ua.com.soft.vitalii.Citrus("Lemon", ua.com.soft.vitalii.Color.yellow, 45));
//        fruits.add(new ua.com.soft.vitalii.Citrus("Lime", ua.com.soft.vitalii.Color.green, 35));
//        fruits.add(new ua.com.soft.vitalii.Citrus("Grapefruit", ua.com.soft.vitalii.Color.red, 50));
//
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
//        try (BufferedWriter writerToConsole = new BufferedWriter(new OutputStreamWriter(System.out))) {
//            for (ua.com.soft.vitalii.Fruit fruit : fruits) {
//                fruit.print(writerToConsole);
//            }
//        } catch (IOException x) {
//            System.err.format("IOException: %s%n", x);
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
//        System.out.println(fruits2);
//        ua.com.soft.vitalii.Fruit fruitApple = new ua.com.soft.vitalii.Fruit();
//        fruitApple.input("apple.txt");
//        fruits.add(fruitApple);

//
//        System.out.println(ua.com.soft.vitalii.Tools.getByColor(fruits, ua.com.soft.vitalii.Color.red));
//        ua.com.soft.vitalii.Tools.sortByName(fruits);
//
//        for (ua.com.soft.vitalii.Fruit fruit : fruits) {
//            fruit.print("fruits.txt");
//            fruit.print();
//        }

    }
}
