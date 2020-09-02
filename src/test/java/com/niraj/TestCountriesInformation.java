package com.niraj;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(ListenerClass.class)
public class TestCountriesInformation {

	@Test
	public void responseUsingFullName() {

		Response rsp = RestAssured.given().baseUri("https://restcountries.eu/").basePath("rest/v2")
				.pathParam("countryName", "Australia").get("/name/{countryName}?fullText=true").then().using().extract()
				.response();

		System.out.println("******Response Using FullName********");
		AssertJUnit.assertEquals(rsp.getStatusCode(), 200);
		System.out.println(rsp.asString());

	}

	@Test
	public void responseUsingListOfCodes() {

		Response rsp = RestAssured.given().baseUri("https://restcountries.eu/").basePath("rest/v2")
				.pathParam("codes", "col;no;ee").get("/alpha/?codes={codes}").then().using().extract()
				.response();
		
		System.out.println("******Response Using ListOfCodes********");
		AssertJUnit.assertEquals(rsp.getStatusCode(), 200);
		System.out.println(rsp.asString());

	}

	@Test
	public void responseUsingCurrency() {

		Response rsp = RestAssured.given().baseUri("https://restcountries.eu/").basePath("rest/v2")
				.pathParam("currency", "cop").get("/currency/{currency}").then().using().extract()
				.response();
		
		System.out.println("******Response Using Currency********");
		AssertJUnit.assertEquals(rsp.getStatusCode(), 200);
		System.out.println(rsp.asString());

	}
	@Test
	public void responseUsingLanguage() {
		
		Response rsp = RestAssured.given().baseUri("https://restcountries.eu/").basePath("rest/v2")
				.pathParam("language", "et").get("/lang/{language}").then().using().extract()
				.response();
		
		System.out.println("******Response Using Language********");
		AssertJUnit.assertEquals(rsp.getStatusCode(), 200);
		System.out.println(rsp.asString());

		
	}
	@Test
	public void responseUsingCapital() {
		
		Response rsp = RestAssured.given().baseUri("https://restcountries.eu/").basePath("rest/v2")
				.pathParam("capital", "Canberra").get("/capital/{capital}").then().using().extract()
				.response();
		
		System.out.println("******Response Using Capital********");
		AssertJUnit.assertEquals(rsp.getStatusCode(), 200);
		System.out.println(rsp.asString());
		
	}

}
