package restGitHub;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepo {

	@Test
	public void test1() {
		
		File datafile = new File("Data.json");
		
		RestAssured.given().auth().oauth2("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")
		.baseUri("https://api.github.com")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(datafile).when().post("user/repos")
		.then().log().all().statusCode(201);
	}
}
