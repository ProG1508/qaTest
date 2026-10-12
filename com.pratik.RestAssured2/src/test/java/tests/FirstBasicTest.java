package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FirstBasicTest {
	
	
	

	@Test
	public void getUser()
	{
		RestAssured
		.given()
		.when().get("https://petstore.swagger.io/v2/user/Check")
		.then().statusCode(200);
		
		
	}
}
