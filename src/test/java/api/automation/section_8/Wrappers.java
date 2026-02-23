package api.automation.section_8;

import io.restassured.path.json.JsonPath;

public class Wrappers {
    public static JsonPath convertToJson(String response) {
        return new JsonPath(response);
    }

}
