package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFiles {
    private static Properties prop = new Properties();
    private static FileInputStream file;
    private static String propertyValue;

    private static String getFilePath(String fileName) {
        return ReadFilePaths.getFilePath(fileName);
    }

    private static FileInputStream getFile(String fileName) {
        file = null;
        String filePath = getFilePath(fileName);
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            // reporting code visit later
        }
        return file;
    }

    public static String getValue(String fileName, String key) {
        propertyValue = null;
        file = getFile(fileName);
        try {
            prop.load(file);
            propertyValue = prop.getProperty(key);
        } catch (IOException e) {
            // reporting code visit later
        }
        return propertyValue;
    }
}