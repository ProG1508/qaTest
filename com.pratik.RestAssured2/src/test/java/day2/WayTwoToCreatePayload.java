package day2;

import org.json.JSONObject;

import io.restassured.RestAssured;

public class WayTwoToCreatePayload {
	
	
	public static void main(String[] args) {
		
		JSONObject jo = new JSONObject();
		
		jo.put("id", "2");
		jo.put("username","Check");
		jo.put("firstName","Sam");
		jo.put("lastName","Pitroda");
		jo.put("email","abc@gmail.com");
		jo.put("password","Check@1234");
		jo.put("phone","9870987890");
		jo.put("userStatus", "2");
		
		RestAssured
		.given()
		.header("accept","application/json")
		 .header("Content-Type", "application/json")
		 .body(jo.toString())
		 .when()
		 .post("https://petstore.swagger.io/v2/user")
		 .then().statusCode(200).log().all();

		
	}
	
}
