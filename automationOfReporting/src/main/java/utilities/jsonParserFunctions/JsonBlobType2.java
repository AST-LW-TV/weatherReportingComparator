package utilities.jsonParserFunctions;

//JSON Blob format -

/*
       [
            value1, value2, value3 ...
       ]
 */

import org.json.simple.JSONArray;

public class JsonBlobType2 extends JsonParser {

    public JsonBlobType2(String nameOfTheFile) {
        super(nameOfTheFile);
    }

    @Override
    public Object jsonParserBlobType(String keyValue) {
        JSONArray jsonArray = (JSONArray) jsonStructure;
        return jsonArray;
    }
}