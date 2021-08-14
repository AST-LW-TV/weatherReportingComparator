package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ReadFilePaths {

    // file path constants used in main
    private static final Supplier<String> CP = () -> "./src/main/resources/ui_properties/browser/chrome.properties";
    private static final Supplier<String> FP = () -> "./src/main/resources/ui_properties/browser/firefox.properties";
    private static final Supplier<String> BP = () -> "./src/main/resources/ui_properties/browser/common/browserProperties.properties";
    private static final Supplier<String> PLM=()->"./src/main/resources/ui_properties/places.json";

    // file path constants used in test
    private static final Supplier<String> SS = () -> "./src/test/resources/screenshots";
    private static final Supplier<String> URL = () -> "src/test/resources/ui_test_properties/urlProperties.properties";
    private static final Supplier<String> PLT = () -> "src/test/resources/ui_test_properties/places.json";

    private static final Map<String, Supplier<String>> MAP = new HashMap<>();

    static {
        MAP.put("chromeProperties", CP);
        MAP.put("firefoxProperties", FP);
        MAP.put("browserProperties", BP);
        MAP.put("screenshotsDir", SS);
        MAP.put("urlProperties", URL);
        MAP.put("placesInMain",PLM);
        MAP.put("places", PLT);
    }

    public static String getFilePath(String nameOfTheFile) {
        return MAP.get(nameOfTheFile).get();
    }
}
