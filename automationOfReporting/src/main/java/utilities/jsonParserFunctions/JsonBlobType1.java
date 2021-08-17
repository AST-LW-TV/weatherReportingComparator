package utilities.jsonParserFunctions;

// JSON Blob is given below and is specific to app -
/*
    {
      "places":[
        "Bengaluru","Chennai","London","Mumbai"
      ]
    }
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonBlobType1 extends JsonParser {

    public JsonBlobType1(String nameOfTheFile) {
        super(nameOfTheFile);
    }

    @Override
    public Object jsonParserBlobType(String keyValue) {
        JSONObject jsonObject = (JSONObject) jsonStructure;
        JSONArray jsonArray = (JSONArray) jsonObject.get(keyValue);
        return jsonArray;
    }
}