package utilities.jsonParserFunctions;

// JSON Blob is given below and is specific to app...
/*
    {
      "places":[
        "Bengaluru","Chennai","London","Mumbai"
      ]
    }
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utilities.ReadFilePaths;

import java.io.FileReader;
import java.io.IOException;

public class JsonBlobType1 extends JsonParser {

    @Override
    public Object jsonParserBlobType() {
        file=null;
        jsonStructure=null;
        try {
            file=new FileReader(ReadFilePaths.getFilePath("places"));
            jsonStructure=jsonParser.parse(file);
        } catch (IOException e) {
                // visit later
        } catch (ParseException e) {
            // visit later
        }

        JSONObject jsonObject=(JSONObject) jsonStructure;
        JSONArray jsonArray=(JSONArray) jsonObject.get("places");
        return jsonArray;
    }
}
