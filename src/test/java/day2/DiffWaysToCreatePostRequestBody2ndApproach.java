package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


//                      2nd   APPROACH APPROACH Post Request Body Using org.json library

public class DiffWaysToCreatePostRequestBody2ndApproach {
	
	@Test(priority=1)
	public void testPostUsingJsonLibrary()
	{
		JSONObject data = new JSONObject();
		data.put("name", "Natarajan");
		data.put("location", "Pondicherry");
		data.put("phone", "8825472920");
		
		String courseArr[]= {"JavaSelenium", "PythonSelenium"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/students")		
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Natarajan"))
			.body("location", equalTo("Pondicherry"))
			.body("phone", equalTo("8825472920"))
			.body("courses[0]", equalTo("JavaSelenium"))
			.body("courses[1]", equalTo("PythonSelenium"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
				
	}
     
	@Test(priority=2)
	public void testDelete()
	{
		when()
		 .delete("http://localhost:3000/students/11")
		 
		.then()
		  .statusCode(200);
	}
}
