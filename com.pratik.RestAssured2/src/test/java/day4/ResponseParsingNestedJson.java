package day4;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseParsingNestedJson {

	@Test
	public static void responseParsingWithNestedJson()
	{
		File f = new File("F:\\Selenium Projects\\Project2\\com.pratik.RestAssured2\\payload2.json");
		
		  Response res = RestAssured 
				  			.given() 
				  				.headers("accept","application/json")
				  				.headers("Content-Type", "application/json") 
				  				.body(f)
				  			.when()
				  				.post("https://petstore.swagger.io/v2/pet");
		  
		  String resString = res.asPrettyString();
		  
		  	System.out.println(resString);
		  	
		  	
		  	JSONObject jo = new JSONObject(resString);
		 
		  	//validation1
		  	
		  	Assert.assertEquals(res.statusCode(), 200);
		  	
		  	//Assert.assertEquals(false, null)
		  	
		  	JSONArray jArray = jo.getJSONArray("tags");
		  	
		  	System.out.println(jArray.toString());
		  	
		  	JSONObject jo1 = jArray.getJSONObject(0);
		  	
		  	System.out.println(jo1.get("name"));
		  	
		  	
		  	int l = jArray.length();
		  	
		  	System.out.println(l);
		  	
		  	
		
	}
	
	
}
