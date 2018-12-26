package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Restclient {
	
	public void Get(String url) throws ClientProtocolException, IOException, JSONException {
	 CloseableHttpClient httpclient= HttpClients.createDefault();
	 HttpGet httpget=new HttpGet(url);
	 
	 CloseableHttpResponse closeableHttpResponse=httpclient.execute(httpget);
	int statuscode= closeableHttpResponse.getStatusLine().getStatusCode();
	System.out.println("Stutus code=="+statuscode);
	
	 String reponsesting=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	 
	 JSONObject responsejson=new JSONObject(reponsesting);
	 System.out.println("json response--"+responsejson);
	 
	Header[] headerarray= closeableHttpResponse.getAllHeaders();
	
	HashMap<String, String> allheaders= new HashMap<String,String>();
	for(Header header:headerarray ) {
		allheaders.put(header.getName(), header.getValue());
		
	}
	System.out.println("header array--"+allheaders);
	 
	}
	
	
	
	public CloseableHttpResponse post(String url, String entity,HashMap<String,String> header) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient= HttpClients.createDefault();
		 HttpPost httppost=new HttpPost(url);
		
		 httppost.setEntity(new StringEntity(entity));
		 
		 for(Map.Entry<String, String> entry: header.entrySet()) {
			 httppost.addHeader(entry.getKey(),entry.getValue());
		 }
		   
		 CloseableHttpResponse closeableHttpResponse=httpclient.execute(httppost);
		 return closeableHttpResponse;
	}
}
