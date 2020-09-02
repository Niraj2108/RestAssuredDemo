package com.niraj;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(ListenerClass.class)
public class TestCountryName {

	@Test
	public void extractCountryname() {

		Response rsp = RestAssured.given().when().get("https://restcountries.eu/rest/v2/name/Australia").then().using().extract()
				.response();

		List<HashMap<String, String>> ls = rsp.jsonPath().getList("$");
		String countryName = ls.get(0).get("name");

		AssertJUnit.assertEquals(rsp.getStatusCode(), 200);
		System.out.println("Country Name is : " + countryName);

	}

}
