package com.niraj;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(ListenerClass.class)
public class TestAllHeaders {
	
	@Test
	public void printAllHeaders() {

		Response rsp = RestAssured.given().when().get("https://restcountries.eu/rest/v2/name/Australia?fullText=true").then().using()
				.extract().response();
			
		
		System.out.println("******Response Using Headers********");
		System.out.println("Headers are : "+ rsp.getHeaders());
		AssertJUnit.assertEquals(rsp.getStatusCode(), 200);
	//	System.out.println(rsp.asString());

	}

}
