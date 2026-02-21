package com.api.noframeworkdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.CreateUserRequest;
import com.api.models.response.CreateUserResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginTestAPIDemoWithFrameworkIntegration {

	@Test(description = "Verify that user is able to login with valid credentials")
	public void test()
	{
		CreateUserRequest createUserRequest = new CreateUserRequest("0", "swag123", "swag", "swag", "swag@abc.com", "swag123", "1234567890", "0");
		
		UserService userService = new UserService();
		Response response =userService.createUser(createUserRequest);
		
		CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
		Assert.assertEquals(createUserResponse.getCode(), "200");
		System.out.println(createUserResponse);
	}
}
