package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTTestCase {
	User payload;
	Logger logger;
	@BeforeClass
	public void EnableLogger() {
		logger  = LogManager.getLogger(this.getClass());
		logger.info("---------------Running DDT Test Case-----------------");
		
	}
	 
	@Test(dataProvider = "Data" ,dataProviderClass = DataProviders.class,priority = 1)
	public void CreateUserTC(String ID, String UserName, String FName, String LName, String EMail,String Pwd,String Phone, String Status) {
		payload = new User();
		logger.info("---------------Fetching data from Excel-----------------");
		payload.setId(Integer.parseInt(ID));
		payload.setUsername(UserName);
		payload.setFirstName(FName);
		payload.setLastName(LName);
		payload.setEmail(EMail);
		payload.setPassword(Pwd);
		payload.setPhone(Phone);
		payload.setUserStatus(Integer.parseInt(Status));
		logger.info("---------------Creating a new user-----------------");
		Response response = UserEndPoints.createUser(payload);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("---------------New User Created-----------------");
	}
	@Test(dataProvider = "UserNames",dataProviderClass = DataProviders.class,priority = 2)
	public void GetUserTC(String uName) {
		logger.info("---------------Reading a new user-----------------");
		Response response = api.endpoints.UserEndPoints.readUser(uName);
		//response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(dataProvider = "UserNames",dataProviderClass = DataProviders.class,priority = 3)
	public void DeleteUserTC(String uName) {
		logger.info("---------------Deleting a user-----------------");
		Response response = api.endpoints.UserEndPoints.deleteUser(uName);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("---------------User Deleted -----------------");
	}

}
