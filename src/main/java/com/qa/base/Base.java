package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	
	public int response_status_code_200=200;
	public int response_status_code_201=201;
	public int response_status_code_400=400;
	public int response_status_code_401=401;
	public int response_status_code_500=500;
	
	 public Properties prop;
	public Base() {
		prop= new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/confg/config.properties");
		prop.load(fis);
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
