package api.endpoints;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class StoreEndPoints {
	public static Response storeInventory() {
		Response response = 
			given()
			.when()
				.get(Routes.get_Store_url);
		return response;
	}

}
