package api.test;
import org.testng.annotations.Test;
import api.endpoints.PetEndPoints;
import io.restassured.response.Response;

public class PetTests {
	int id = 12;
	String PetName;
	@Test(priority = 1,enabled = true)
	public void TestPetModule() {
		Response response = PetEndPoints.register_pet(id);
		response.then().log().all();
		PetName=response.jsonPath().get("name");
		
		System.out.println("Pet id is "+id+"and Pet name is "+PetName);
	}
}
