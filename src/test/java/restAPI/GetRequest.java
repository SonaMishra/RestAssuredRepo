package restAPI;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("employees");
		
		System.out.println(response.getBody().asString());
		
		JsonPath jpath = response.jsonPath();
		
		List<String> names = jpath.get("name");
		
		List<String> Salary = jpath.get("salary");
		
		
		for(String str:names){
			System.out.println(str);
		}
		
		for(String str:Salary){
			System.out.println(str);
		}
		
	}
}
