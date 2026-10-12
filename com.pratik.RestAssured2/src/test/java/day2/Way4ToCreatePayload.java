package day2;

import java.io.File;

import io.restassured.RestAssured;

public class Way4ToCreatePayload {
	
	public static void main(String[] args) {
		
		File f = new File("F:\\Selenium Projects\\Project2\\com.pratik.RestAssured2\\src\\test\\java\\payload.json");
		
		RestAssured
		.given()
		 	.header("accept","application/json")
		 	.header("Content-Type", "application/json")
		 	.body(f)
		.when()
		 	.post("https://petstore.swagger.io/v2/user")
		 .then()
		 	.statusCode(200)
		 	.log().all();
	}

}
