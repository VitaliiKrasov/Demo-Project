package ua.com.soft.vitalii;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class XMLToolsTest {
    File list_fruits;

    @BeforeMethod
    public void setUp() {
        list_fruits = new File(XMLTools.getFile());
    }

    @AfterClass
    public void clean() {
        list_fruits.delete();
    }

    @Test
    public void testSaveAndRead() {
//        arrange
        List<Fruit> expected = new LinkedList<Fruit>();
        expected.add(new Fruit("Bananas", Color.yellow));
        expected.add(new Citrus("Lemon", Color.yellow, 45.0));
        expected.add(new Citrus("Lime", Color.green, 35.1));
        expected.add(new Citrus("Grapefruit", Color.red, 50));
//        act
        try {
            XMLTools.save(expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Fruit> actual = new ArrayList<Fruit>();

        try {
            actual.addAll(XMLTools.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        assert
        assertEquals(actual, expected);
    }
}