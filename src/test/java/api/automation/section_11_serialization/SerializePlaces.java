package api.automation.section_11_serialization;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializePlaces {
    String place_id;

    Location location;

    @BeforeMethod
    public void preRequisite() {
        RestAssured.baseURI="https://rahulshettyacademy.com";
    }
    @Test
    public void CreatePlaceAPICall() {
        Place place = new Place();
        List<String> list = new ArrayList<>();
        location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        place.setLocation(location);
        place.setAccuracy(50);
        place.setName("kaushi & ranju house");
        place.setPhone_number("1234567890");
        place.setAddress("29, side layout, cohen 09");
        list.add("shoe park");
        list.add("shop");
        place.setTypes(list);
        place.setWebsite("https://rahulshettyacademy.com");
        place.setLanguage("Italian-IN");
        PlaceResp resp = given().log().all().
                queryParam("key", "qaclick123").
                header("Content-Type", "application/json").
                body(place).
                when().log().all().
                post("/maps/api/place/add/json").
                then().log().all().
                assertThat().statusCode(200).extract().response().as(PlaceResp.class);

        place_id=resp.getPlace_id();
        System.out.println("Place ID: "+place_id);


    }
}
