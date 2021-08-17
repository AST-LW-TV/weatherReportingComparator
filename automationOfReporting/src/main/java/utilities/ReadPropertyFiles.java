package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// reads the property files for us

public class ReadPropertyFiles {

    private static Properties prop = new Properties();
    private static FileInputStream file;
    private static String propertyValue;

    // returns file path when file name is given
    private static String getFilePath(String fileName) {
        return ReadFilePaths.getFilePath(fileName);
    }

    // allocates the file
    private static FileInputStream getFile(String fileName) {
        file = null;
        String filePath = getFilePath(fileName);
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

    // returns the property value from property file
    public static String getValue(String fileName, String key) {
        propertyValue = null;
        file = getFile(fileName);
        try {
            prop.load(file);
            propertyValue = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}