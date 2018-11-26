package ua.com.soft.vitalii.tools;

public class Cutter {
    public static String[] getArgs(String line) {
        if (line.startsWith("class")) {
            line = line.substring(6);
        }
        line = line.replaceAll(", name ", " ").replaceAll(", color ", " ").replaceAll(", contains ", " ").replaceAll("mg vitamin C", " ");
        String[] args = line.split("\\s+");
        return args;
    }
}
