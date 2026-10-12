package httpRequests;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class ReqResAPIs {
	
	
	
	
	@Test(priority = 1)
	void getObjectList()
	{
		
		
		given()
		
		.when()
			.get("https://api.restful-api.dev/objects")
			
		
		.then()
			.statusCode(200)
			.log().all();
		
		System.out.println("----------------------------------------------");
		
		
	}
	
	@Test(priority = 2)
	void addObject()
	{
		
		HashMap<String, Object> jsonData = new HashMap<>();
	    jsonData.put("year", 2019);
	    jsonData.put("price", 1849.99);
	    jsonData.put("CPU model", "Intel Core i9");
	    jsonData.put("Hard disk size", "1 TB");
		
		
		
		
		HashMap hm = new HashMap();
		hm.put("name", "Apple MacBook Pro 16");
		hm.put("data", jsonData);
		
		
		given()
			.header("content-type","application/json")
			.body(hm)
		.when()
			.post("https://api.restful-api.dev/objects")
			
		.then()
			.statusCode(200)
			.log().all();
	}

}
