package com.api.base;

import com.api.models.request.CreateUserRequest;

import io.restassured.response.Response;

public class UserService extends BaseService{
	private static final String BASE_PATH = "";

	public Response createUser(CreateUserRequest payload)
	{
		return postRequest(payload, BASE_PATH + "/user");
	}
}
