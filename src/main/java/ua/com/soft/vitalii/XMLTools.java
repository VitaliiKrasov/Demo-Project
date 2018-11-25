package ua.com.soft.vitalii;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XMLTools {
    private static String file = "list_fruits.xml";

    public static String getFile() {
        return file;
    }

    public static void save(List<Fruit> fruits) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(fruits);
        encoder.close();
        fos.close();
    }

    public static List<Fruit> read() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        XMLDecoder decoder = new XMLDecoder(fis);
        List<Fruit> result = (List<Fruit>) decoder.readObject();
        decoder.close();
        fis.close();
        return result;
    }
}
