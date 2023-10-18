package api.endpoints;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	public static Response register_pet(int id) {
		Response response = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id",id)
		.when()
			.get(Routes.get_pet_url);
		return response;		
	}

}
