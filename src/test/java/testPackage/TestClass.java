package testPackage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TestClass {
	@Test
	void getUser() 
    {
          given()
          
          .when()
                 .get("http://reqres.in/api/users?page=2")
          
          .then()
                 .statusCode(200)
                 .body("page",equalTo(2))
                 .log().body();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing .....");

	}

}
