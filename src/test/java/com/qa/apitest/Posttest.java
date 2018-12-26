package com.qa.apitest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.Base;
import com.qa.client.Restclient;
import com.qa.data.User;

public class Posttest  extends Base{
	
	Base testbase;
	String ServiceUrl;
	String ApiUrl;
	String url;
	Restclient restclient;
	CloseableHttpResponse closeableHttpResponse;
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException, JSONException {
		testbase= new Base();
		 ServiceUrl=prop.getProperty("ServiceUrl");
		 ApiUrl=prop.getProperty("ApiUrl");
		
		 url=ServiceUrl+ApiUrl;
		
	}
	
	@Test
	public void postTest() throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		restclient=new Restclient();
		
		HashMap<String, String> headermap=new HashMap< String,String>();
		headermap.put("Content-Type", "application/json");
		//jakson api
		ObjectMapper mapper=new ObjectMapper();
		User user= new User("morfan","leader");
		
		// java object to json file
		mapper.writeValue(new File("C:\\Users\\new201809\\RestassuredProject\\src\\main\\java\\com\\qa\\data\\user.json"), user);
		
		//object to json in string
		 String jsonString=mapper.writeValueAsString(user);
		 System.out.println(jsonString);
		 
		 closeableHttpResponse= restclient.post(url, jsonString, headermap);
		
		 //status code
		int statuscode= closeableHttpResponse.getStatusLine().getStatusCode();
		 Assert.assertEquals(statuscode, testbase.response_status_code_201);
		
		 //jsons string
		String reponseString= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		 JSONObject jsonObject=new JSONObject(reponseString);
		 System.out.println("response of json is >>"+jsonObject);
		 //json to java object
		User userreponse= mapper.readValue(reponseString, User.class);
		System.out.println(userreponse);
		
		System.out.println(user.getName().equals(userreponse.getName()));
		
		System.out.println(user.getJob().equals(userreponse.getJob()));
		 
	}

}
