package ua.com.soft.vitalii;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.testng.Assert.assertEquals;

public class FruitTest {
    @DataProvider(name = "dataFruits")
    public static Object[][] createData() {
        return new Object[][] {{" Avocado  Green ", new Fruit("Avocado", Color.GREEN)},
                {"Peach RED", new Fruit("Peach", Color.RED)},};
    }
    @Test(dataProvider = "dataFruits")
    public void testInput(String input, Fruit expected) throws IOException, FruitException {
//        arrange
        Fruit actual = new Fruit();
        BufferedReader br = new BufferedReader(new StringReader(input));
//        act
        actual.input(br);
//        assert
        assertEquals(actual, expected);
    }

    @Test (expectedExceptions = FruitException.class)
    public void testFruitExceptionInInput() throws IOException, FruitException {
//        arrange
        String test = " ";
        Fruit actual = new Fruit();
        BufferedReader br = new BufferedReader(new StringReader(test));
//        act
//        assert
        actual.input(br);
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void testIOExceptionInInput() throws IOException, FruitException {
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