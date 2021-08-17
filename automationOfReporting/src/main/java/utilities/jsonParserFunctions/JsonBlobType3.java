package utilities.jsonParserFunctions;

//JSON Blob format -

/*
        {
            key:value
            key1:value1
        }
 */

import org.json.simple.JSONObject;

public class JsonBlobType3 extends JsonParser {

    public JsonBlobType3(String nameOfTheFile) {
        super(nameOfTheFile);
    }

    @Override
    public Object jsonParserBlobType(String keyValue) {
        JSONObject jsonObject = (JSONObject) jsonStructure;
        return jsonObject;
    }
}