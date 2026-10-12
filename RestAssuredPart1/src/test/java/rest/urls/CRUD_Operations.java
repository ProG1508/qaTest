package rest.urls;


import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import io.restassured.response.Response;
import rest.payload.CreatedUser;

import static io.restassured.RestAssured.*;

public class CRUD_Operations {
	
	public static Response post_user_method (CreatedUser payload)
	{
		Response res = given()
		 .header("Content-Type","application/json")
		 .header("accept","application/json")
		 .body(payload)
		 
		.when()
			.post(URL_Operations.post_URL);
		
		return res;
		
	}
	
	public static void get_user_method (String userName)
	{
		Response res = given()
		 .header("Content-Type","application/json")
		 .header("accept","application/json")
		 .pathParam("user", userName)
		 
		.when()
			.post(URL_Operations.get_URL);
		
	}
	
	public static void post_user_method (String userName, CreatedUser payload)
	{
		Response res = given()
		 .header("Content-Type","application/json")
		 .header("accept","application/json")
		 .pathParam("userName", userName)
		 .body(payload)
		 
		.when()
			.post(URL_Operations.put_URL);
		
	}
	
	public static void delete_user_method (String userName, CreatedUser payload)
	{
		Response res = given()
		 .header("Content-Type","application/json")
		 .header("accept","application/json")
		 .pathParam("userName", userName)
		
		 
		.when()
			.post(URL_Operations.delete_URL);
	}
	
	
	
	

}
