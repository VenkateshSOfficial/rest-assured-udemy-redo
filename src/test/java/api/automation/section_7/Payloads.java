package api.automation.section_7;


import io.restassured.path.json.JsonPath;
import org.apache.commons.io.FileUtils;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


public class Payloads {
    public static String addBookPayload(String bookName,String isbn,String aisle,String author){
        return "{\n" +
                "\n" +
                "\n" +
                "\"name\":\""+bookName+"\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\""+author+"\"\n" +
                "}\n";
    }
    public static JsonPath convertToJson(String response) {
        return new JsonPath(response);
    }

    public static List<HashMap<String, String>> readJsonFile() throws IOException {
        String jsonContent = FileUtils.readFileToString(
                new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\addBook.json"),
                StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>()
        {});
    }

}
