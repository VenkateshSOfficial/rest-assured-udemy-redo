package api.automation.section_8;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Jira {
    String defectId;
    String attachmentsId;

    @BeforeTest
    public void preRequisite(){
        RestAssured.baseURI="https://kaushik230691.atlassian.net";
    }
    @Test(priority = 0)
    public void createIssue(){
        String createIssueResponse = given().header("Content-Type", "application/json").
                header("Authorization", "Basic a2F1c2hpazIzMDY5MUBnbWFpbC5jb206QVRBVFQzeEZmR0YwTEl3Q2Nyc1JjVnJMbXgtaGs3anVlV1o3cGF3WVcwZXhjSlozV0xWaU94V0J5SDJxVDdDM1hNdnJOaVRaZEVKalNTNjF4LWRBQU5DTU5MblVDQXZZdTdQS3JrQmI2X0Z0eTNjS2RNaXhiOUU2U29tMzEwcTVVRXp4ZlVIQUF6UmdJUk9CNU1hLWdfWnMzTV9HY0RwTWotclR5OEpIRXlJR0VMV0Y4bkotbnBrPTIwNTM1RjdB")
                .body("{\n" +
                        "  \"fields\": {\n" +
                        "    \"project\": {\n" +
                        "      \"key\": \"KAN\"\n" +
                        "    },\n" +
                        "    \"summary\": \"App failed to connect to server.\",\n" +
                        "    \"description\": {\n" +
                        "      \"type\": \"doc\",\n" +
                        "      \"version\": 1,\n" +
                        "      \"content\": [\n" +
                        "        {\n" +
                        "          \"type\": \"paragraph\",\n" +
                        "          \"content\": [\n" +
                        "            {\n" +
                        "              \"text\": \"This is the description of the new issue, using Atlassian Document Format.\",\n" +
                        "              \"type\": \"text\"\n" +
                        "            }\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    },\n" +
                        "    \"issuetype\": {\n" +
                        "      \"name\": \"Bug\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}\n").
                when().post("/rest/api/3/issue").
                then().assertThat().statusCode(201).extract().response().asPrettyString();
        JsonPath js = Wrappers.convertToJson(createIssueResponse);
        defectId = js.getString("id");
        System.out.println(createIssueResponse);
        System.out.println("ID: " + defectId);
    }

    @Test(dependsOnMethods = "createIssue")
    public void addAttachments(){
        String addAttachmentsResponse = given().header("X-Atlassian-Token", "no-check").
                header("Authorization", "Basic a2F1c2hpazIzMDY5MUBnbWFpbC5jb206QVRBVFQzeEZmR0YwTEl3Q2Nyc1JjVnJMbXgtaGs3anVlV1o3cGF3WVcwZXhjSlozV0xWaU94V0J5SDJxVDdDM1hNdnJOaVRaZEVKalNTNjF4LWRBQU5DTU5MblVDQXZZdTdQS3JrQmI2X0Z0eTNjS2RNaXhiOUU2U29tMzEwcTVVRXp4ZlVIQUF6UmdJUk9CNU1hLWdfWnMzTV9HY0RwTWotclR5OEpIRXlJR0VMV0Y4bkotbnBrPTIwNTM1RjdB").
                multiPart("file", new File("C:\\Users\\venkatesh_swaminatha\\IdeaProjects\\rest-assured-udemy-redo\\src\\test\\java\\resources\\example.png")).
                pathParam("issueId", defectId).
                when().post("/rest/api/3/issue/{issueId}/attachments").
                then().assertThat().statusCode(200).extract().response().asPrettyString();

        JsonPath js = Wrappers.convertToJson(addAttachmentsResponse);
        attachmentsId = js.getString("id");
        System.out.println(addAttachmentsResponse);
        System.out.println("ID: " + attachmentsId);
    }
}
