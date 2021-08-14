package utilities.jsonParserFunctions;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import utilities.ReadFilePaths;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonBlobType2 extends JsonParser {


    @Override
    public Object jsonParserBlobType() {
        file=null;
        jsonStructure=null;
        try{
            file=new FileReader(ReadFilePaths.getFilePath("placesInMain"));
            jsonStructure=jsonParser.parse(file);
        } catch (IOException e) {
            // visit later
        } catch (ParseException e) {
            // visit later
        }

        JSONArray jsonArray=(JSONArray) jsonStructure;
        return jsonArray;

    }
}
