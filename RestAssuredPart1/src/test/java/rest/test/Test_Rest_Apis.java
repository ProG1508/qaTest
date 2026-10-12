package rest.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import rest.payload.CreatedUser;
import rest.urls.CRUD_Operations;

public class Test_Rest_Apis {
	
	Faker fk;
	CreatedUser user;
	
	@BeforeClass
	public void userData ()
	{
		
		fk = new Faker();
		
		user = new CreatedUser();
	
		user.setId(fk.idNumber().hashCode());
		
		user.setUsername(fk.name().username());
		user.setFirstName(fk.name().firstName());
		
		user.setLastName(fk.name().lastName());
		
		user.setEmail(fk.internet().safeEmailAddress());
		
		user.setPassword(fk.internet().password(5, 10));
		
		user.setPhone(fk.phoneNumber().cellPhone());
		
		
	}
	
	
	@Test(priority=1)
	 public void test_post_user()
	 {
		CRUD_Operations.post_user_method(user);
	 }
	
	public void test_get_user()
	{
		
	}

}
