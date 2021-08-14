package utilities.jsonParserFunctions;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import utilities.ReadFilePaths;

import java.io.FileReader;
import java.io.IOException;

/*
       [
            value1, value2, value3 ...
       ]
 */

public class JsonBlobType2 extends JsonParser {


    public JsonBlobType2(String nameOfTheFile) {
        super(nameOfTheFile);
    }

    @Override
    public Object jsonParserBlobType() {
        JSONArray jsonArray=(JSONArray) jsonStructure;
        return jsonArray;
    }
}
