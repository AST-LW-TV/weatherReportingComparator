package service_layer_automation.get_requests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import service_layer_automation.common.CentiToFaren;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import utilities.ReadPropertyFiles;

import static io.restassured.RestAssured.given;

public class GetCurrentWeather {

    public int currentTemperature(SetQueryParamsForCurrentTemp queryParams) {
        RestAssured.baseURI= ReadPropertyFiles.getValue("hostPath","openWeatherAppDomain");
        String response = given()
                .param("q", queryParams.getQ())
                .param("appid", queryParams.getAppid())
                .when().get(ReadPropertyFiles.getValue("resourcesPath", "openWeatherResourcesPath"))
                .then().extract().response().asString();
        JsonPath js=new JsonPath(response);
        float temperature=js.get("main.temp");
        return CentiToFaren.conversion(temperature);
    }
}
