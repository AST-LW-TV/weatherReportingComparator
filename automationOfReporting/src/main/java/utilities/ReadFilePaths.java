package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ReadFilePaths {

    // file path constants used in main
    private static final Supplier<String> CP = () -> "./src/main/resources/ui_properties/chrome.properties";
    private static final Supplier<String> FP = () -> "./src/main/resources/ui_properties/firefox.properties";
    private static final Supplier<String> BP = () -> "./src/main/resources/ui_properties/common/browserProperties.properties";

    // file path constants used in test
    private static final Supplier<String> SS = () -> "./src/test/screenshots";

    private static final Map<String, Supplier<String>> MAP = new HashMap<>();

    static {
        MAP.put("chromeProperties", CP);
        MAP.put("firefoxProperties", FP);
        MAP.put("browserProperties", BP);
        MAP.put("screenshotsDir", SS);
    }

    public static String getFilePath(String nameOfTheFile) {
        return MAP.get(nameOfTheFile).get();
    }
}
