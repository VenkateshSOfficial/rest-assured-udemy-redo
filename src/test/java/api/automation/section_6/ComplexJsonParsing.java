package api.automation.section_6;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParsing {
	int totalCourses;
	int totalSum=0;

	@Test(priority = 0)
	public void printNoOfCourses() {
		JsonPath js = Payload.convertToJson(Payload.coursesPrice());
		totalCourses = js.getInt("courses.size()");
		System.out.println("Total number of courses " + totalCourses);
	}

	@Test(priority = 1)
	public void printPurchaseAmount() {
		JsonPath js = Payload.convertToJson(Payload.coursesPrice());
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("The purchase amount is " + purchaseAmount);

	}

	@Test(priority = 2)
	public void printCourseTitle() {
		JsonPath js = Payload.convertToJson(Payload.coursesPrice());
		List<String> coursesTitle = js.getList("courses.title");
		coursesTitle.stream().findFirst().ifPresent(System.out::println);
	}

	@Test(priority = 3)
	public void printAllCourses() {
		JsonPath js = Payload.convertToJson(Payload.coursesPrice());
		
		for (int i = 0; i < totalCourses; i++) {
			System.out.println(js.getString("courses[" + i + "].title"));
			System.out.println(js.getString("courses[" + i + "].price"));
		}
	}
	@Test(priority = 4)
	public void printRPACourseCopies(){
		JsonPath js = Payload.convertToJson(Payload.coursesPrice());
		for(int i=0;i<totalCourses;i++){
			if(js.getString("courses[" + i + "].title").equalsIgnoreCase("rpa")){
				System.out.println("total copies of RPA : " + js.getString("courses[" + i + "].copies"));
				break;
			}
		}
	}
	@Test(priority = 5)
	public void sumOfAllPrices(){
		JsonPath js = Payload.convertToJson(Payload.coursesPrice());
		for(int i=0;i<totalCourses;i++){
			totalSum+=js.getInt("courses[" + i + "].price")*
					js.getInt("courses[" + i + "].copies");
		}
		System.out.println("The total sum is : " + totalSum);
		Assert.assertEquals(totalSum,910);
	}
}
