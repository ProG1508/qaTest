package day3;

import java.io.File;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseParsingwithJSONObject {
	
	@Test
	public static void responseParsingJSONObjectMethod()
	{
		
		File f = new File("F:\\Selenium Projects\\Project2\\com.pratik.RestAssured2\\src\\test\\java\\payload.json");
		
		
		
		Response  res = RestAssured
				.given()
					.header("Content-Type","application/json")
					.header("accept","application/json")
					.body(f)
				.when()
					.post("https://petstore.swagger.io/v2/user");
		
		String resString = res.asString();
		
		JSONObject jo = new JSONObject(resString);
		
		System.out.println(res.asPrettyString());
		
		System.out.println(jo.getInt("code"));
		
		System.out.println(jo.optString("name"));
		
	}

}
