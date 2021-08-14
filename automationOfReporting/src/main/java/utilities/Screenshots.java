package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

        public static void TakeScreenShot(WebDriver driver, String fileName) {
            try {
                String path = ReadFilePaths.getFilePath("screenshotPath");
                int count = new File(path).list().length;
                File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShotFile, new File(path + fileName + ".png"));
            } catch (IOException e) {
                System.out.println("Screenshot error...");
                System.exit(-1);
            }
        }
}
