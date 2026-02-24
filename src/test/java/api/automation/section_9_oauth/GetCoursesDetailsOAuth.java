package api.automation.section_9_oauth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetCoursesDetailsOAuth {
    Map<String,String> formParams=new HashMap<>();
    String access_token;
    public JsonPath convertRawToJason(String response){
        return new JsonPath(response);
    }
    @BeforeTest
    public void preRequisite(){
        RestAssured.baseURI="https://rahulshettyacademy.com";
    }
    @Test(priority = 0)
    public void generateToken(){
        formParams.put("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
        formParams.put("client_secret","erZOWM9g3UtwNRj340YYaK_W");
        formParams.put("grant_type","client_credentials");
        formParams.put("scope","trust");

        String tokenResponse = given().formParams(formParams).
                when().post("/oauthapi/oauth2/resourceOwner/token").
                then().assertThat().statusCode(200).extract().response().asPrettyString();

        JsonPath js = convertRawToJason(tokenResponse);
        access_token=js.get("access_token");
        System.out.println("access_token : "+access_token);
    }

    @Test(priority = 1)
    public void getCourses(){
        String coursesResponse = given().queryParam("access_token", access_token).
                when().get("/oauthapi/getCourseDetails").
                then().assertThat().statusCode(401).extract().response().asPrettyString();
        JsonPath js = convertRawToJason(coursesResponse);
        System.out.println(coursesResponse);
        List<Map<String, String>> webAutomationCourses = js.getList("courses.webAutomation");
        for (Map<String, String> webCourse : webAutomationCourses) {
            System.out.println("Course Title: " + webCourse.get("courseTitle"));
            System.out.println("Price: " + webCourse.get("price"));
        }
    }
}
