package com.maven.RestassuredProject;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Putdata {
	@Test
	public void getWeatherDetails() throws JSONException {
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requetparam=	new JSONObject();
		requetparam.put("Firstname", "Mayur");
		requetparam.put("Lastname", "Girase");
		requetparam.put("Mobile no.", "9421273956");
		requetparam.put("Address", "Pune");
		requetparam.put("Email", "mayurvgirase@gmail.com");
		httprequest.header("Content-type","application/json");
		httprequest.body(requetparam.toString());
		Response reponse=httprequest.post("/register");
		
		int code=reponse.getStatusCode();
		System.out.println("code"+code);
		Assert.assertEquals(code, "409");
		String sucesscode= reponse.jsonPath().get("Success");
		System.out.println(sucesscode);
		Assert.assertEquals(sucesscode,"operation Success");
	}
}
