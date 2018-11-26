package ua.com.soft.vitalii.tools;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CutterTest {
    @DataProvider(name = "dataArgs")
    public static Object[][] createData() {
        String[] s1 = {"Fruit", "Avocado", "Green"};
        String[] s2 = {"Fruit", "Peach", "red"};
        String[] s3 = {"Citrus", "Lemon", "yellow", "53"};
        String[] s4 = {"Fruit", "Bananas", "white"};

        return new Object[][]{{"Fruit Avocado  Green ", s1},
                {"Fruit Peach red", s2},
                {"class Citrus, name Lemon, color yellow, contains 53mg vitamin C", s3},
                {"class Fruit, name Bananas, color white", s4},
        };
    }

    @Test(dataProvider = "dataArgs")
    public void testGetArgs(String line, String[] expected) {
//        arrange
//        act
        String[] actual = Cutter.getArgs(line);
//        assert
        assertEquals(actual, expected);
    }
}