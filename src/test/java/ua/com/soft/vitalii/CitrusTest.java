package ua.com.soft.vitalii;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.testng.Assert.assertEquals;

public class CitrusTest {
    @DataProvider(name = "dataCitruses")
    public static Object[][] createData() {
        return new Object[][] {{"Orangelo yellow 40", new Citrus("Orangelo", Color.yellow, 40)},
                {"  Clementine  orange 48.8", new Citrus("Clementine", Color.orange, 48.8)},
                {"Tangerine red 26.7", new Citrus("Tangerine", Color.red, 26.7)}};
    }
    @Test(dataProvider = "dataCitruses")
    public void testInput(String input, Fruit expected) throws IOException, FruitException {
        // arrange
        Fruit actual = new Citrus();
        BufferedReader br = new BufferedReader(new StringReader(input));

        // act
        actual.input(br);

        // assert
        assertEquals(actual, expected);
    }

}