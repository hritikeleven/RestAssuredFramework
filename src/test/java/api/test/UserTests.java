package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	public Logger logger;
	//String username;
	
	@BeforeClass
	public void Datageneration() {
		
		faker= new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password(6, 12));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(0);	
		//logs
		logger =LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void TestUserModuleCreate() {
		
		logger.info("---------------Creating a new user-----------------");
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//System.out.println("Newuser created :- "+this.userpayload.getUsername());
		//System.out.println(this.userpayload.getFirstname());
		//System.out.println(this.userpayload.getLastname());
		//String userName = response.jsonPath().get("username");
		//username = userName;
		logger.info("---------------New User created succesfully-----------------");
	}
	
	@Test(priority = 2)
	public void TestUserModuleRead() {
		logger.info("---------------Reading new user-----------------");
		//Response response =UserEndPoints.readUser(username);
		System.out.println("User Details :-");
		
		Response response = UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().body();	
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	public void TestUserModuleUpdate() {
		logger.info("---------------Updating the user details-----------------");
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setUserStatus(1);
		
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		System.out.println(this.userpayload.getUsername()+" User got updated....");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response updateresponse = UserEndPoints.readUser(this.userpayload.getUsername());
		updateresponse.then().log().body();
		logger.info("---------------User Updated succesfully-----------------");
		
	}
	@Test(priority = 4)
	public void TestUserModuleDelete() {
		logger.info("---------------Deleting the User-----------------");
		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().body();
		
		System.out.println(this.userpayload.getUsername()+" User Deleted...");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("---------------User deleted succesfully-----------------");
		
	}

}
