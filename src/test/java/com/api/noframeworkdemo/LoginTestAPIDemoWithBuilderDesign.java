package com.api.noframeworkdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.CreateUserRequest;
import com.api.models.response.CreateUserResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginTestAPIDemoWithBuilderDesign {

	@Test(description = "Verify that user is able to login with valid credentials")
	public void test() {
		CreateUserRequest createUserRequest = new CreateUserRequest.Builder()
		.id("0")
		.userName("swag123")
		.firstName("swag")
		.lastName("swag")
		.email("swag@abc.com")
		.password("swag123")
		.phone("1234567890")
		.userStatus("0")
		.build();

		UserService userService = new UserService();
		CreateUserResponse createUserResponse = userService.createUser(createUserRequest).as(CreateUserResponse.class);

		System.out.println("Response Data: " + createUserResponse.toString());
		Assert.assertEquals(createUserResponse.getCode(), "200");
	}
}
