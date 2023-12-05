package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

//5TH   APPROACH APPROACH Post Request Body Using EXTERNAL JSON(CHECKING GIT)
public class DiffWaysToCreatePostRequestBody5thApproach {

	@Test(priority=1)
	void testPostUsingPOJO() {
		POJO_PostRequest pojpo = new POJO_PostRequest();
		pojpo.setName("Natarajan");
		pojpo.setLocation("Pondicherry");
		pojpo.setPhone("8637458681");
		
		String courseArr[]= {"Java", "API"};
		
		pojpo.setCourses(courseArr);
		
		given()
		.contentType("application/json")
		.body(pojpo)
		
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Natarajan"))
		.body("location",equalTo("Pondicherry"))
		.body("phone",equalTo("8637458681"))
		.body("courses[0]",equalTo("Java"))
		.body("courses[1]",equalTo("API"))
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
