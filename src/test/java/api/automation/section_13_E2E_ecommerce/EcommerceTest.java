package api.automation.section_13_E2E_ecommerce;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class EcommerceTest {
    String token;
    String productId;
    String productOrderId;
    String orderId;
   public RequestSpecification requestSpec(){
       return new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
               .build();
   }
   public ResponseSpecification responseSpec(){
       return new ResponseSpecBuilder().expectContentType(ContentType.JSON)
               .build();
   }
   @BeforeTest
   public void login(){
       LoginRequestPojo loginPojo = new LoginRequestPojo();
       loginPojo.setUserEmail("venkatesh230691@gmail.com");
       loginPojo.setUserPassword("CENA@wwe2014");

       LoginResponsePojo loginResponse = given().spec(requestSpec()).contentType(ContentType.JSON).body(loginPojo).
               when().post("/api/ecom/auth/login").then().spec(responseSpec()).extract()
               .response().as(LoginResponsePojo.class);

       token = loginResponse.getToken();
       System.out.println("token : " + token);
   }
   @Test
   public void addProduct(){

       AddProductResponse productResponse = given().spec(requestSpec())
               .param("productName","Laptop")
               .param("productAddedBy",token)
               .param("productCategory","electronics")
               .param("productSubCategory","gadgets")
               .param("productPrice","1500")
               .param("productDescription","lap original")
               .param("productFor","men")
               .multiPart("productImage", new File("C:\\Users\\venkatesh_swaminatha\\Documents\\rest-assured-udemy-redo\\src\\test\\java\\images\\laptop.png"))
               .header("Authorization",token).
               when().post("/api/ecom/product/add-product").
               then().spec(responseSpec()).statusCode(201).extract().response().as(AddProductResponse.class);

       productId=productResponse.getProductId();
       System.out.println("product id : " + productId);
   }
   @Test(dependsOnMethods = "addProduct")
   public void createOrder(){
       CreateOrderPojo createOrderPojo = new CreateOrderPojo();
       Orders order = new Orders();
       order.setCountry("India");
       order.setProductOrderedId(productId);

       List<Orders> orderDetails=new ArrayList<>();
       orderDetails.add(order);
       createOrderPojo.setOrders(orderDetails);


       CreateOrderResponsePojo createOrderResponse = given().spec(requestSpec()).body(createOrderPojo).contentType(ContentType.JSON).header("Authorization", token).
               when().post("/api/ecom/order/create-order").
               then().spec(responseSpec()).statusCode(201).extract().response().as(CreateOrderResponsePojo.class);

       productOrderId = String.valueOf(createOrderResponse.getProductOrderId());
       orderId= String.valueOf(createOrderResponse.getOrders());
       System.out.println("order id : " + orderId);
       System.out.println("product order id : " + productOrderId);
   }
   @Test(dependsOnMethods = "createOrder")
   public void deleteOrder(){
        String resp = given().header("Authorization", token).spec(requestSpec()).
                pathParam("productId",productId).
                when().delete("/api/ecom/product/delete-product/{productId}").
                then().spec(responseSpec()).extract().response().asPrettyString();
        String message = new JsonPath(resp).getString("message");
        Assert.assertEquals(message,"Product Deleted Successfully");
        System.out.println(message);
    }
}
