package day2;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

//                1st   APPROACH Post Request Body Using HashMap

public class DiffWaysToCreatePostRequestBody {
	
	@Test(priority=1)
	public void testCreateUsingHashMap()
	{
		
		HashMap data = new HashMap();
		data.put("name", "Ashok");
		data.put("location", "Pondicherry");
		data.put("phone", "8637458681");
		
		String courseArr[]= {"PythonSelenium", "API"};
		data.put("courses", courseArr);
				
		 given()
		 .contentType("application/json")
		 .body(data)     	     	 
         .when()
		      .post("http://localhost:3000/students")         
		
         .then()
         .statusCode(201)
         .body("name",equalTo("Ashok"))
         .body("location",equalTo("Pondicherry"))
         .body("phone",equalTo("8637458681"))
         .body("courses[0]", equalTo("PythonSelenium"))
         .body("courses[1]", equalTo("API"))
         .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
		
	}
	
	@Test(priority=2)
	public void testDelete() 
	{
	  
				
		when()
		   
		 .delete("http://localhost:3000/students/4");
		
		
	}
	

}

