package ua.com.soft.vitalii;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrchardTest {
    @DataProvider(name = "dataOrchard")
    public static Object[][] createData() {
        return new Object[][] {{"Avocado", new Fruit("Avocado", Color.green)},
                {"Grapefruit", new Citrus("Grapefruit", Color.red, 31.2)},
                {"Lemon", new Citrus("Lemon", Color.red, 53)}};
    }

    @Test(dataProvider = "dataOrchard")
    public void testGetFruit(String name, Fruit expected) {
        // arrange

        // act
        Fruit actual = Orchard.valueOf(name).get();

        // assert
        Assert.assertEquals(actual, expected);
    }
}