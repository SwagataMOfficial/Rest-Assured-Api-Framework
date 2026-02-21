package com.api.noframeworkdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginTestAPIDemo1 {

	@Test(description = "Verify that user is able to login with valid credentials")
	public void test()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		RequestSpecification given = RestAssured.given();
		RequestSpecification header = given.header("Content-Type", "application/json");
		header.body("{\"id\":0,\"username\":\"swag123\",\"firstName\":\"swag\",\"lastName\":\"swag\",\"email\":\"swag@abc.com\",\"password\":\"swag123\",\"phone\":\"1234567890\",\"userStatus\":0}");
		Response response = header.post("/user");
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);

	}
}
