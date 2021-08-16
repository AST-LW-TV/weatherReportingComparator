package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    public static void TakeScreenShot(String status, WebDriver driver, String fileName) {
        String filePath = (status.equalsIgnoreCase("success"))
                ? ReadFilePaths.getFilePath("success") : ReadFilePaths.getFilePath("failure");
        try {
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShotFile, new File(filePath + fileName + ".png"));
        } catch (IOException e) {
            System.out.println("Screenshot error...");
            System.exit(-1);
        }
    }
}