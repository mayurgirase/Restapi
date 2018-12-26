package com.qa.apitest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.client.Restclient;

public class GetapiTest  extends Base{
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
	public void getTest() throws ClientProtocolException, IOException, JSONException {
		restclient=new Restclient();
		restclient.Get(url);
	}
	

}
