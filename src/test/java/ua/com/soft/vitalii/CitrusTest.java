package ua.com.soft.vitalii;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.com.soft.vitalii.exceptions.ColorException;
import ua.com.soft.vitalii.exceptions.UnknownFruitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.testng.Assert.assertEquals;

public class CitrusTest {
    @DataProvider(name = "dataCitruses")
    public static Object[][] createData() {
        return new Object[][]{{"Citrus Orangelo yellow 40", new Citrus("Orangelo", Color.YELLOW, 40)},
                {" Citrus Clementine  orange 48.8", new Citrus("Clementine", Color.ORANGE, 48.8)},
                {"class Citrus, name Tangerine, color red, contains 26.7mg vitamin C", new Citrus("Tangerine", Color.RED, 26.7)}
        };
    }

    @Test(dataProvider = "dataCitruses")
    public void testInput(String input, Fruit expected) throws IOException, ColorException, UnknownFruitException {
        // arrange
        Fruit actual = new Citrus();
        BufferedReader br = new BufferedReader(new StringReader(input));

        // act
        actual.input(br);

        // assert
        assertEquals(actual, expected);
    }

}