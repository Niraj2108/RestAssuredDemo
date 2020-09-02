package com.niraj;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(ListenerClass.class)
public class TestResponseCodes {

	@Test
	public void Method1() {
		Response rsp = RestAssured.given().baseUri("https://restcountries.eu/").basePath("rest/v2")
				.pathParam("countryName", "ABC").get("/name/{countryName}").then().using().extract().response();

		System.out.println("******Response: Not Found********");
		System.out.println(rsp.getStatusCode());
		AssertJUnit.assertEquals(rsp.getStatusCode(), 404);
		// System.out.println(rsp.asString());

	}

	@Test
	public void Method2() {
		Response rsp = RestAssured.given().baseUri("https://restcountries.eu/").basePath("rest/v2")
				.pathParam("countryName", "Australia").post("/name/{countryName}").then().using().extract().response();

		//Here we use post method but it is not allowed.
		System.out.println("******Response: Method Not Allowed********");
		System.out.println(rsp.getStatusCode());
		AssertJUnit.assertEquals(rsp.getStatusCode(), 405);
		// System.out.println(rsp.asString());
	}

}
