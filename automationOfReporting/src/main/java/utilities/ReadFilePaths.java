package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ReadFilePaths {

    // file path constants used in main (UI automation)
    private static final Supplier<String> CP = () -> "./src/main/resources/ui_properties/browser/chrome.properties";
    private static final Supplier<String> FP = () -> "./src/main/resources/ui_properties/browser/firefox.properties";
    private static final Supplier<String> BP = () -> "./src/main/resources/ui_properties/browser/common/browserProperties.properties";

    // file path constants used main (Service layer in automation)
    private static final Supplier<String> HD = () -> "./src/main/resources/service_layer_properties/hostDomain.properties";
    private static final Supplier<String> RD = () -> "./src/main/resources/service_layer_properties/resourcesDomain.properties";

    // file path constants used in test (UI automation)
    private static final Supplier<String> SS = () -> "./src/test/resources/screenshots";
    private static final Supplier<String> URL = () -> "./src/test/resources/ui_test_properties/urlProperties.properties";
    private static final Supplier<String> PL1 = () -> "./src/test/resources/ui_test_properties/dataForWindSpeedChecking.json";
    private static final Supplier<String> PL2 = () -> "./src/test/resources/ui_test_properties/dataForSearchBarResults.json";

    // file path constants used in test (Service layer in automation)
    private static final Supplier<String> KY = () -> "./src/test/resources/service_layer_test_properties/keys/stagingKeys.properties";
    private static final Supplier<String> QP1 = () -> "./src/test/resources/service_layer_test_properties/weatherQueryParams1.json";
    private static final Supplier<String> CF = () -> "src/test/resources/logic_properties/commonFileForLogic.properties";

    // file path constant for screenshots
    private static final Supplier<String> SH = () -> "src/test/resources/screenshots";

    private static final Map<String, Supplier<String>> MAP = new HashMap<>();

    static {
        MAP.put("chromeProperties", CP);
        MAP.put("firefoxProperties", FP);
        MAP.put("browserProperties", BP);
        MAP.put("screenshotsDir", SS);
        MAP.put("urlProperties", URL);
        MAP.put("placesInMain", PL1);
        MAP.put("places", PL2);
        MAP.put("hostPath", HD);
        MAP.put("resourcesPath", RD);
        MAP.put("queryParam1", QP1);
        MAP.put("stagingKeys", KY);
        MAP.put("commonFile", CF);
        MAP.put("screenshotPath",SH);
    }

    public static String getFilePath(String nameOfTheFile) {
        return MAP.get(nameOfTheFile).get();
    }
}
