package utilities.jsonParserFunctions;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utilities.ReadFilePaths;

import java.io.FileReader;
import java.io.IOException;

public abstract class JsonParser {

    protected JSONParser jsonParser;
    protected FileReader file;
    protected Object jsonStructure;

    public abstract Object jsonParserBlobType();

    public JsonParser(String nameOfTheFile) {
        jsonParser = new JSONParser();
        file = null;
        jsonStructure = null;
        try {
            file = new FileReader(ReadFilePaths.getFilePath(nameOfTheFile));
            jsonStructure = jsonParser.parse(file);
        } catch (IOException e) {
            // visit later
        } catch (ParseException e) {
            // visit later
        }
    }
}
