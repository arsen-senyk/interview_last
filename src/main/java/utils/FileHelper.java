package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class FileHelper {

    public static String reader(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
