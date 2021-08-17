package service_layer_automation.get_requests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import service_layer_automation.common.CentiToFaren;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import utilities.ReadPropertyFiles;

import static io.restassured.RestAssured.given;

public class GetCurrentWeather {

    private String response;
    private JsonPath js;

    // helper method for getting the response from GET call
    private void miniFactory(SetQueryParamsForCurrentTemp queryParams) {
        RestAssured.baseURI = ReadPropertyFiles.getValue("hostPath", "openWeatherAppDomain");
        response = given()
                .param("q", queryParams.getQ())
                .param("appid", queryParams.getAppid())
                .when().get(ReadPropertyFiles.getValue("resourcesPath", "openWeatherResourcesPath"))
                .then().extract().response().asString();
        js = new JsonPath(response);
    }

    // returns the current wind speed from informational module
    public float currentWindSpeed(SetQueryParamsForCurrentTemp queryParams) {
        miniFactory(queryParams);
        float windSpeed = js.get("wind.speed");
        return windSpeed;
    }

    // returns the current temperature from informational module
    public int currentTemperature(SetQueryParamsForCurrentTemp queryParams) {
        miniFactory(queryParams);
        float temperature = js.get("main.temp");
        return CentiToFaren.conversion(temperature);
    }
}