package day3;

import org.testng.annotations.Test;

import day2.UserPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseParsing {
	
	
	@Test
	public static void responseParsingMethod() {
		
		
		UserPayload up2 = new UserPayload();
		
		Response  res = RestAssured
			.given()
				.header("Content-Type","application/json")
				.header("accept","application/json")
				.body(up2)
			.when()
				.post("https://petstore.swagger.io/v2/user");
		
		
		
		System.out.println("==================================");
		
		System.out.println(res.asString());
		
		System.out.println("==================================");
		System.out.println(res.statusCode());
		
		System.out.println("==================================");
		System.out.println(res.getBody());
		
		System.out.println("==================================");
		System.out.println(res.asString());
		
		System.out.println("==================================");
		System.out.println(res.asPrettyString());
		
		String Stringres = res.asString();
		System.out.println("==================================");
		
		
		
	}
	
	
	
	
	
}
