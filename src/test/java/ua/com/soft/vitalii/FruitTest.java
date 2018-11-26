package ua.com.soft.vitalii;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.com.soft.vitalii.exceptions.ColorException;
import ua.com.soft.vitalii.exceptions.UnknownFruitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.testng.Assert.assertEquals;

public class FruitTest {
    @DataProvider(name = "dataFruits")
    public static Object[][] createData() {
        return new Object[][]{{"Fruit Avocado  Green ", new Fruit("Avocado", Color.GREEN)},
                {"Fruit Peach red", new Fruit("Peach", Color.RED)},
                {"class Fruit, name Bananas, color white", new Fruit("Bananas", Color.WHITE)},
        };
    }

    @Test(dataProvider = "dataFruits")
    public void testInput(String input, Fruit expected) throws IOException, UnknownFruitException, ColorException {
//        arrange
        Fruit actual = new Fruit();
        BufferedReader br = new BufferedReader(new StringReader(input));
//        act
        actual.input(br);
//        assert
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = UnknownFruitException.class)
    public void testFruitExceptionInInput() throws IOException, UnknownFruitException, ColorException {
//        arrange
        String test = " ";
        Fruit actual = new Fruit();
        BufferedReader br = new BufferedReader(new StringReader(test));
//        act
//        assert
        actual.input(br);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testIOExceptionInInput() throws IOException, UnknownFruitException, ColorException {
//        arrange
        String test = "";
        Fruit actual = new Fruit();
        BufferedReader br = new BufferedReader(new StringReader(test));
//        act
//        assert
        actual.input(br);
    }

    @Test
    public void testPrint() {

    }
}