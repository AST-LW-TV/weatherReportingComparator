### Project Structure
```

    +-- automationOfReporting
        +-- src
            +-- main
                +--java
                    +-- service_layer_automation
                        +-- common
                            +-- CentiToFaren.java
                            +-- KmhrToMhr.java
                        +-- data_driving_classes
                            +-- SetQueryParamsForCurrentTemp.java
                        +-- get_requests
                            +-- GetCurrentWeather.java
                    +-- ui_automation
                        +-- commons
                            +-- WebActions.java
                        +-- components
                            +-- AbstractComponent.java
                            +-- InformationModule.java
                            +-- PolicyAcceptanceComponent.java
                            +-- SearchComponent.java
                        +-- pages
                            +-- AccuWeatherHomePage.java
                            +-- AccuWeatherResultsPage.java
                    +-- utilities
                        +-- browserSetup
                            +-- browsers
                                +-- ChromeBrowser.java
                                +-- FirefoxBrowser.java
                                +-- SafariBrowser.java
                            +-- BrowserConfiguration.java
                            +-- BrowserFactory.java
                        +-- jsonParserFunctions
                            +-- JsonBlobType1.java
                            +-- JsonBlobType2.java
                            +-- JsonBlobType3.java
                            +-- JsonParser.java
                        +-- ExpilictDriverWaits.java
                        +-- GiveDateOfCreation.java
                        +-- ReadFilePaths.java
                        +-- ReadPropertyFiles.java
                        +-- Screenshots.java
                        +-- VideoRecorder.java
                +-- resources 
                    +-- service_layer_properties
                        +-- hostDomain.properties
                        +-- resourcesDomain.properties
                    +-- ui_properties
                        +-- browser
                            +-- browserProperties.properties
                        +-- chrome_properties.json
                        +-- firefox_properties.json
            +-- test
                +-- java
                    +-- com.test
                        +-- logic_tests
                            +-- BaseTest.java
                            +-- TemperatureComparatorLogicTest.java
                            +-- WindSpeedComparatorLogicTest.java
                        +-- service_layer_tests
                            +-- ValidatingWindSpeedTest.java
                        +-- ui_tests
                            +-- BaseTest.java
                            +-- CheckWindSpeedTest.java
                            +-- IsPolicyBlockDisplayedTest.java
                            +-- SearchBarSuggestionTest.java
                    +-- Listeners.java
                +-- resources
                    +-- logic_properties
                        +-- commonFileForLogic.properties
                    +-- screenshots
                        +-- failed_tests
                        +-- success_tests
                    +-- service_layer_test_properties
                        +-- keys
                            +-- stagingKeys.properties
                        +-- weatherQueryParams1.json
                    +-- test_videos
                    +-- ui_test_properties
                        +-- dataForSearchBarResults.json
                        +-- dataForWindSpeedChecking.json
                        +-- urlProperties.properties
        +-- LogicTesting.xml
        +-- RegressionTest_API.xml
        +-- RegressionTest_UI.xml
                               
```

### Patterns Used in Application

- Single Responsibility Principle - All the components implemented, follow this principle
- Factory Pattern - [BrowserFactory Class](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/java/utilities/browserSetup/BrowserFactory.java) implements this pattern
- Builder Pattern - [SetQueryParamsForCurrentTemp Class](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/java/service_layer_automation/data_driving_classes/SetQueryParamsForCurrentTemp.java) uses Builder principle

### Features

- Allure Reports of Tests
- [Screenshots](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/java/utilities/Screenshots.java)
    - using TestNG listeners, stored at [screenshots dir](https://github.com/AST-LW-TV/weatherReportingComparator/tree/main/automationOfReporting/src/test/resources/screenshots) - separated for failed and success tests
    - using Allure support - are shown when Allure serves "allure-results"
- [Video Recording](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/java/utilities/VideoRecorder.java)
    - stored at [test_videos](https://github.com/AST-LW-TV/weatherReportingComparator/tree/main/automationOfReporting/src/test/resources/test_videos)
- Supports three browsers **Chrome**, **Firefox**, **Safari**  

### Tests

- [logic_tests](https://github.com/AST-LW-TV/weatherReportingComparator/tree/main/automationOfReporting/src/test/java/com/test/logic_tests)
    - [TemperatureComparatorLogicTest](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/java/com/test/logic_tests/TemperatureComparatorLogicTest.java) - compares current temperature from UI and API using desired variance
    - [WindSpeedComparatorLogicTest](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/java/com/test/logic_tests/WindSpeedComparatorLogicTest.java) - Additional test for comparing the wind speed against a variance

maven command for executing tests

```
mvn clean compile -P logic_testing test
```    

- [service_layer_tests](https://github.com/AST-LW-TV/weatherReportingComparator/tree/main/automationOfReporting/src/test/java/com/test/service_layer_tests)
    - [ValidatingWindSpeedTest](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/java/com/test/service_layer_tests/ValidatingWindSpeedTest.java) - validating wind speed from API

maven command to execute test

```
mvn clean compile -P api_testing test
```

- ui_tests
    - [CheckWindSpeedTest](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/java/com/test/ui_tests/CheckWindSpeedTest.java) - validates wind speed from UI
    - [IsPolicyBlockDisplayedTest](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/java/com/test/ui_tests/IsPolicyBlockDisplayedTest.java) - verifies whether policy block is present or not
    - [SearchBarSuggestionsTest](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/java/com/test/ui_tests/SearchBarSuggestionsTest.java) - validates number of suggestions

maven command for executing tests

```
mvn clean compile -P ui_testing test
```

### Data Driven from JSON and Properties file

- for UI
    - [URL Data](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/resources/ui_test_properties/urlProperties.properties)
    - [browserProperties](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/resources/ui_properties/browser/common/browserProperties.properties) - which browser to execute, which in turn driven by profile in pom.xml
    - Optional Arguments for Browser -  [chrome](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/resources/ui_properties/browser/chrome_properties.json), [firefox](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/resources/ui_properties/browser/firefox_properties.json)
    - Data for suggestions test [Search Bar Results](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/resources/ui_test_properties/dataForSearchBarResults.json)
    - Data for [wind speed](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/resources/ui_test_properties/dataForWindSpeedChecking.json) test


- for service layer ( API )

    - [Host Domain](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/resources/service_layer_properties/hostDomain.properties) + [Resources Domain](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/resources/service_layer_properties/resourcesDomain.properties) = URI
    
      Host Domain | Resource Domain
      ----------- | ----------------
      https://www.abc.com/ | /hello-world/index.html

    - [keys](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/resources/service_layer_test_properties/keys/stagingKeys.properties) for different environments
    - Data for [Query Paramters](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/resources/service_layer_test_properties/weatherQueryParams1.json) which are used in *GET* request


- for Probelm Statement
    - [Places](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/resources/logic_properties/commonFileForLogic.properties) info for both UI and API

### Reports

- Allure reports can be obtained by executing the following command after running tests

```
allure serve allure-results
```

![](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/test/resources/screenshots/Allure_Sample.png)


### Supports

- Default is **Chrome**


- [Chrome Browser](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/java/utilities/browserSetup/browsers/ChromeBrowser.java)
  ```
  mvn clean compile -P chrome_execution test
  ```
- [Firefox Browser](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/java/utilities/browserSetup/browsers/FirefoxBrowser.java)
  ```
  mvn clean compile -P firefox_execution test
  ```

- [Safari Browser](https://github.com/AST-LW-TV/weatherReportingComparator/blob/main/automationOfReporting/src/main/java/utilities/browserSetup/browsers/SafariBrowser.java)
  ```
  mvn clean compile -P safari_execution test
  ```
