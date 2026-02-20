package api.automation.section_5;

import io.restassured.path.json.JsonPath;

public class Wrappers {
	public static JsonPath convertToJson(String response) {
		return new JsonPath(response);
	}
	
	public static String addPlaceAPI() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"kaushi & ranju house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String updatePlaceAPI(String place_id, String key) {
	    return "{\r\n"
	            + "\"place_id\":\"" + place_id + "\",\r\n"
	            + "\"address\":\"70 st petersburg, Russia\",\r\n"
	            + "\"key\":\"" + key + "\"\r\n"
	            + "}";
	}
	
}
