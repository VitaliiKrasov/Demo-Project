package ua.com.soft.vitalii;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.com.soft.vitalii.exceptions.ColorException;
import ua.com.soft.vitalii.exceptions.UnknownFruitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.testng.Assert.assertEquals;

public class FactoryTest {
    @DataProvider(name = "dataCitruses")
    public static Object[][] createData() {
        return new Object[][]{{"Citrus Orangelo yellow 40", new Citrus("Orangelo", Color.YELLOW, 40)},
                {" Citrus Clementine  orange 48.8", new Citrus("Clementine", Color.ORANGE, 48.8)},
                {"class Citrus, name Tangerine, color red, contains 26.7mg vitamin C", new Citrus("Tangerine", Color.RED, 26.7)},
                {"Peach", new Fruit("Peach", Color.RED)},
                {"Fruit Peach red", new Fruit("Peach", Color.RED)},
                {"Grapefruit", new Citrus("Grapefruit", Color.RED, 31.2)},
                {"class Fruit, name Bananas, color white", new Fruit("Bananas", Color.WHITE)}
        };
    }

    @Test(dataProvider = "dataCitruses")
    public void testGet(String input, Fruit expected) throws IOException, ColorException, UnknownFruitException {
        // arrange
        BufferedReader br = new BufferedReader(new StringReader(input));

        // act
        Fruit actual = Factory.get(br);

        // assert
        assertEquals(actual, expected);
    }
}