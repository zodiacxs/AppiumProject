package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTests {
	
	@Test
	public void getCatFacts() {
		
		RestAssured.baseURI = "https://catfact.ninja/fact";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response object
		Response response = httpRequest.request(Method.GET);
		
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
		System.out.println("Response body:" + responseBody);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
}
