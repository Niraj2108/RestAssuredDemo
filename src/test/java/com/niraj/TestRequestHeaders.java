package com.niraj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TestRequestHeaders {

	@Test
	public void manipulateHeaders() {

		given().header("Content-Type", "application/json", "Access-Control-Allow-Methods", "GET").when()
				.get("https://restcountries.eu").then().statusCode(200);

		
		// Here I used two headers..
	}

}
