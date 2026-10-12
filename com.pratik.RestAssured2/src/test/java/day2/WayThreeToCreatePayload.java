package day2;

import io.restassured.RestAssured;

public class WayThreeToCreatePayload {
	
	public static void main(String[] args) {
		
		
		UserPayload up = new UserPayload();
		
		up.setId(3);
		up.setUsername("Person3");
		up.setFirstName("Aakash");
		up.setLastName("Mhatre");
		up.setEmail("ap001@gmail.com");
		up.setPassword("Password@1234");
		up.setPhone("9876567890");
		up.setUserStatus(3);
		
		RestAssured
		.given()
		 	.header("accept","application/json")
		 	.header("Content-Type", "application/json")
		 	.body(up)
		.when()
		 	.post("https://petstore.swagger.io/v2/user")
		 .then()
		 	.statusCode(200)
		 	.log().all();
		
		
		
	}

}
