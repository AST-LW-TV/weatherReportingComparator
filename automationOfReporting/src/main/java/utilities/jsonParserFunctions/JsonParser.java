package utilities.jsonParserFunctions;


import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public abstract class JsonParser {

    protected JSONParser jsonParser;
    protected FileReader file;
    protected Object jsonStructure;

    public abstract Object jsonParserBlobType();

    public JsonParser() {
        jsonParser = new JSONParser();
    }
}
