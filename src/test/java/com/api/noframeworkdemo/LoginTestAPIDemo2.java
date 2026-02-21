package com.api.noframeworkdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginTestAPIDemo2 {

	@Test(description = "Verify that user is able to login with valid credentials")
	public void test()
	{
		Response response = 
			given()
			.baseUri("https://petstore.swagger.io/v2")
			.header("Content-Type", "application/json")
			.body("{\"id\":0,\"username\":\"swag123\",\"firstName\":\"swag\",\"lastName\":\"swag\",\"email\":\"swag@abc.com\",\"password\":\"swag123\",\"phone\":\"1234567890\",\"userStatus\":0}")
			.post("/user");
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);

	}
}
