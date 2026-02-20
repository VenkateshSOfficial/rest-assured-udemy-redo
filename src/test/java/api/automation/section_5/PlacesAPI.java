package api.automation.section_5;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;



public class PlacesAPI {
	String place_id;
	
	@BeforeMethod
	public void preRequisite() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
	}
	@Test
	public void CreatePlaceAPICall() {
		String response = given().
		queryParam("key", "qaclick123").
		header("Content-Type","application/json").
		body(Wrappers.addPlaceAPI()).
		when().
		post("/maps/api/place/add/json").
		then().
		// using hamcrest equalTo() method to validate the response body
		assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asPrettyString();	
		System.out.println(response);
		
		JsonPath js = Wrappers.convertToJson(response);
		place_id = js.getString("place_id");
		System.out.println("The place id : " + place_id);
		Assert.assertEquals(js.getString("status"),"OK");
	}
	
	@Test(dependsOnMethods = "CreatePlaceAPICall")
	public void updatePlaceAPICall() {
		String updatePlaceResponse = given().
		queryParam("key", "qaclick123").queryParam("place_id", place_id).
		header("Content-Type","application/json").
		body(Wrappers.updatePlaceAPI(place_id, "qaclick123")).
		when().
		put("/maps/api/place/update/json").
		then().
		assertThat().statusCode(200).extract().response().asPrettyString();
		
		JsonPath js = Wrappers.convertToJson(updatePlaceResponse);
		System.out.println(js.getString("msg"));
		Assert.assertEquals(js.getString("msg"),"Address successfully updated");
	}
	
	@Test(dependsOnMethods = "updatePlaceAPICall")
	public void getPlaceAPICall() {
		String getPlaceResponse = given().
				queryParam("key", "qaclick123").queryParam("place_id", place_id).
				header("Content-Type","application/json").
				when().get("/maps/api/place/get/json").then().
				assertThat().statusCode(200).extract().response().asPrettyString();
		
		JsonPath js = Wrappers.convertToJson(getPlaceResponse);
		System.out.println(getPlaceResponse);
		System.out.println("The updated address : " + js.getString("address"));
        Assert.assertEquals(js.getString("address"),"70 st petersburg, Russia");
	}
}
