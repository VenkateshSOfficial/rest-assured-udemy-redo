package api.automation.section_7;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LibraryAPI {
    String bookId;
    @BeforeMethod
    public void preRequisite(){

        RestAssured.baseURI="http://216.10.245.166";
    }

    @Test(dataProvider = "getBooks")
    public void addBook(String bookName,String isbn,String aisle,String author){
        String addBookResponse = given().header("Content-Type", "application/json").
                body(Payloads.addBookPayload(bookName,isbn,aisle,author)).
                when().post(" Library/Addbook.php").
                then().assertThat().statusCode(200).extract().response().asPrettyString();
        JsonPath js = Payloads.convertToJson(addBookResponse);
        System.out.println(js.getString("Msg"));
        Assert.assertEquals(js.getString("Msg"),"successfully added");
        bookId=js.getString("ID");
        System.out.println("The created book id : " + bookId);
    }

    @Test(dataProvider = "getBooksUsingMaps")
    public void addBookUsingMap(HashMap<String,String> input){
        String addBookResponse = given().header("Content-Type", "application/json").
                body(Payloads.addBookPayload(input.get("bookName"),input.get("isbn"),input.get("aisle"),input.get(""))).
                when().post(" Library/Addbook.php").
                then().assertThat().statusCode(200).extract().response().asPrettyString();
        JsonPath js = Payloads.convertToJson(addBookResponse);
        System.out.println(js.getString("Msg"));
        Assert.assertEquals(js.getString("Msg"),"successfully added");
        bookId=js.getString("ID");
        System.out.println("The created book id : " + bookId);
    }

    @Test(dataProvider = "getBooksUsingJsonFile")
    public void addBookUsingJsonFile(HashMap<String,String> input){
        String addBookResponse = given().header("Content-Type", "application/json").
                body(Payloads.addBookPayload(input.get("name"),input.get("isbn"),input.get("aisle"),input.get(""))).
                when().post(" Library/Addbook.php").
                then().assertThat().statusCode(200).extract().response().asPrettyString();
        JsonPath js = Payloads.convertToJson(addBookResponse);
        System.out.println(js.getString("Msg"));
        Assert.assertEquals(js.getString("Msg"),"successfully added");
        bookId=js.getString("ID");
        System.out.println("The created book id : " + bookId);
    }
    @Test
    public void addBookUsingFiles() throws IOException {
        String addBookResponse = given()
                .header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\addBook.json"))))
                .when()
                .post("Library/Addbook.php") // <-- removed leading space
                .then()
                .assertThat().statusCode(200)
                .extract().response().asPrettyString();

        System.out.println("Raw response: " + addBookResponse); // Debug print

        JsonPath js = Payloads.convertToJson(addBookResponse);
        System.out.println(js.getString("Msg"));
        Assert.assertEquals(js.getString("Msg"), "successfully added");
        bookId = js.getString("ID");
        System.out.println("The created book id : " + bookId);
    }


    @DataProvider
    public Object[][] getBooks(){
        return new Object[][] {
                {"harry potter chamber of secrets","chamber","01","JK rowling"},
                {"harry potter prisnor of azkaban","Azkaban","02","JK rowling"}
        };
    }

    @DataProvider
    public Object[][] getBooksUsingMaps(){
        Map<String,String> book1=new HashMap<>();
        Map<String,String> book2=new HashMap<>();

        book1.put("bookName","harry potter chamber of secrets");
        book1.put("isbn","chamber");
        book1.put("aisle","01");
        book1.put("author","JK rowling");

        book2.put("bookName","harry potter prisnor of azkaban");
        book2.put("isbn","Azkaban");
        book2.put("aisle","02");
        book2.put("author","JK rowling");

        return new Object[][] {
                {book1},
                {book2}
        };
    }

    @DataProvider
    public Object[][] getBooksUsingJsonFile() throws IOException {
        List<HashMap<String,String>> books=Payloads.readJsonFile();
        return new Object[][] {
                {books.get(0)},
                {books.get(1)}
        };
    }
}
