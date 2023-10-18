package api.test;
import org.testng.annotations.Test;

import api.endpoints.StoreEndPoints;
import io.restassured.response.Response;

public class StoreTests {
	PetTests Status;
	@Test
	public void TestStoreModuleGetInventory() {
		Response response = StoreEndPoints.storeInventory();
		response.then().log().all();
		//Assert.assertEquals(response.jsonPath().get("status"), Status);
	}

}
