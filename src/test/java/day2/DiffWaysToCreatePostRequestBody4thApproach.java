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

//4TH   APPROACH APPROACH Post Request Body Using EXTERNAL JSON(GIT pull)
public class DiffWaysToCreatePostRequestBody4thApproach {
    		
	@Test(priority=1)
	void testPostUsingExternalJson() throws FileNotFoundException {
	    
		File f= new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name",equalTo("NatarajanAshok"))
			.body("location",equalTo("Pondicherry"))
			.body("phone",equalTo("882547292"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
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
