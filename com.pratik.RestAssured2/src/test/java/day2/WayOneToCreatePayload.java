package day2;

import java.util.HashMap;

import io.restassured.RestAssured;

public class WayOneToCreatePayload {
	
	public static void main(String[] args) {
		
		
HashMap<String, String > data = new HashMap<>();
		
		data.put("id", "1");
		data.put("username","Check");
		data.put("firstName","Sam");
		data.put("lastName","Pitroda");
		data.put("email","abc@gmail.com");
		data.put("password","Check@1234");
		data.put("phone","9870987890");
		
		
		
		
		 RestAssured 
		 .given()
		 .header("accept","application/json")
		 .header("Content-Type", "application/json")
		 .body(data)
		 .when()
		 .post("https://petstore.swagger.io/v2/user")
		 .then().statusCode(200).log().all();
		 
		
	}
	
	
	
	

	
	
	
	
}
