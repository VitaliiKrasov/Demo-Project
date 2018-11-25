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
        fruits.add(new Citrus("Lime", Color.GREEN, 15));
        fruits.add(new Fruit("Apple", Color.YELLOW));
        fruits.add(new Fruit("Apple", Color.RED));
        fruits.add(new Citrus("Lemon", Color.YELLOW, 20));
        fruits.add(new Fruit("Bananas", Color.BROWN));
        return fruits;
    }

    @Test
    public void testGetByColor() {
//        arrange
        List fruits = getTestList();

        List<Fruit> expected = new LinkedList<Fruit>();
        expected.add(new Fruit("Apple", Color.YELLOW));
        expected.add(new Citrus("Lemon", Color.YELLOW, 20));
//        act
        List<Fruit> actual = getByColor(fruits, Color.YELLOW);
//        assert
        assertEquals(actual, expected);
    }
    @Test
    public void testSortByName() {
//        arrange
        List<Fruit> fruits = getTestList();

        List<Fruit> expected = new LinkedList<Fruit>();
        expected.add(new Fruit("Apple", Color.YELLOW));
        expected.add(new Fruit("Apple", Color.RED));
        expected.add(new Fruit("Bananas", Color.BROWN));
        expected.add(new Citrus("Lemon", Color.YELLOW, 20));
        expected.add(new Citrus("Lime", Color.GREEN, 15));
//        act
        sortByName(fruits);
//        assert
        assertEquals(fruits, expected);
    }
}