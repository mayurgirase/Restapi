package com.maven.RestassuredProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public class Getdata {
	@Test
	public void getWeatherDetails() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response reponse=httprequest.get("/Pune");
		
		 String responseBody =reponse.getBody().asString();
		 System.out.println("Response body ="+responseBody);
		  
	}
	
	
	/*@Test
	public void testresponsecode() {
		int code=get(api).getStatusCode();
		System.out.println("code"+code);
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void testbody() {
		long time=get().getTime();
		System.out.println("response time:"+time);
	}*/

}
