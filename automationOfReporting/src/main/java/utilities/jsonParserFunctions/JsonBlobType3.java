package utilities.jsonParserFunctions;

import org.json.simple.JSONObject;

/*
        {
            key:value
            key1:value1
        }
 */

public class JsonBlobType3 extends JsonParser {

    public JsonBlobType3(String nameOfTheFile) {
        super(nameOfTheFile);
    }

    @Override
    public Object jsonParserBlobType() {
        JSONObject jsonObject = (JSONObject) jsonStructure;
        return jsonObject;
    }
}
