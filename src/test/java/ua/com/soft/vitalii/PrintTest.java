package ua.com.soft.vitalii;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import static org.testng.Assert.assertEquals;

public class PrintTest {
    @DataProvider(name = "dataPrint")
    public static Object[][] printData() {
        String s1 = "class Fruit, name Bananas, color white";
        String s2 = "class Citrus, name Grapefruit, color red, contains 31.2mg vitamin C";
        String s3 = "class Citrus, name Lemon, color yellow, contains 53.0mg vitamin C";
        String s4 = "class Citrus, name Lime, color green, contains 29.1mg vitamin C";
        String s5 = "class Citrus, name Orange, color orange, contains 53.2mg vitamin C";
        return new Object[][]{{new Fruit("Bananas", Color.WHITE), s1},
            {new Citrus("Grapefruit", Color.RED, 31.2), s2},
            {new Citrus("Lemon", Color.YELLOW, 53), s3},
            {new Citrus("Lime", Color.GREEN, 29.1), s4},
            {new Citrus("Orange", Color.ORANGE, 53.2), s5}
        };
    }

    @Test(dataProvider = "dataPrint")
    public void testPrint(Fruit fruit, String expected) throws IOException {
//        arrange
        StringWriter sw = new StringWriter();
        try (BufferedWriter bw = new BufferedWriter(sw)) {
//        act
            String actual = sw.toString();
            fruit.print(bw);
//        assert
            assertEquals(actual, expected);
        }
    }
}