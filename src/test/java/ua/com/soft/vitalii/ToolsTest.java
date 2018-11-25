package ua.com.soft.vitalii;//import main.ua.com.soft.vitalii.Citrus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static ua.com.soft.vitalii.Tools.getByColor;
import static ua.com.soft.vitalii.Tools.sortByName;

public class ToolsTest {
    @BeforeMethod
    static List getTestList() {
        List<Fruit> fruits = new LinkedList<Fruit>();
        fruits.add(new Fruit("Apple", Color.yellow));
        fruits.add(new Fruit("Apple", Color.red));
        fruits.add(new Citrus("Lemon", Color.yellow, 20));
        fruits.add(new Citrus("Lime", Color.green, 15));
        return fruits;
    }

    @Test
    public void testGetByColor() {
//        arrange
        List fruits = getTestList();

        List<Fruit> expected = new LinkedList<Fruit>();
        expected.add(new Fruit("Apple", Color.yellow));
        expected.add(new Citrus("Lemon", Color.yellow, 20));
//        act
        List<Fruit> actual = getByColor(fruits, Color.yellow);
//        assert
        assertEquals(actual, expected);
    }
    @Test
    public void testSortByName() {
//        arrange
        List<Fruit> fruits = getTestList();

        List<Fruit> expected = new LinkedList<Fruit>();
        expected.add(new Fruit("Apple", Color.yellow));
        expected.add(new Fruit("Apple", Color.red));
        expected.add(new Citrus("Lemon", Color.yellow, 20));
        expected.add(new Citrus("Lime", Color.green, 15));
//        act
        sortByName(fruits);
//        assert
        assertEquals(fruits, expected);
    }
}