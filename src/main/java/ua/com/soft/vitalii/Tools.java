package ua.com.soft.vitalii;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Tools {

    public static List<Fruit> getByColor (List<Fruit> fruits, Color color) {
        List<Fruit> result = new LinkedList<Fruit>();
        for (Fruit fruit : fruits) {
            if (fruit.getColor() == color) {
                result.add(fruit);
            } else continue;
        }
        return result;
    }

    public static void sortByName (List<Fruit> fruits) {
        Collections.sort(fruits, new FruitNameComparator());
    }

    private static class FruitNameComparator implements Comparator<Fruit> {
        @Override
        public int compare(Fruit f, Fruit f1) {
            return f.getName().compareTo(f1.getName());
        }
    }
}
