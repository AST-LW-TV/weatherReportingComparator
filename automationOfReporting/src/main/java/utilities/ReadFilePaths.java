package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ReadFilePaths {

    // file path constants
    private static final Supplier<String> BPF=
            () -> "./src/main/resources/browserProperties.properties";

    private static final Map<String,Supplier<String>> MAP=new HashMap<>();

    static{
        MAP.put("browserPropertiesPath",BPF);
    }

    public static String getFilePath(String nameOfTheFile){
        return MAP.get(nameOfTheFile).get();
    }

}
