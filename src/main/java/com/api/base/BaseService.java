package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	private static final String BASE_URL = "https://petstore.swagger.io/v2";
	private RequestSpecification requestSpecification;
	
	public BaseService()
	{
		requestSpecification = RestAssured.given().baseUri(BASE_URL);
	}
	
	protected Response postRequest(Object payLoad, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);
	}
	
	
}
