package com.RestAssuredFW.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class PropertyFileReader {
	
	Properties prop = new Properties();
	InputStream input = null;
	
	public  PropertyFileReader(String filename){
		try {
		String filepath = System.getProperty("user.dir") ;
			input = new FileInputStream(filepath + "/Resources/" + filename);
			
			// load a properties file
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getPropertyVal(String key){
		return prop.getProperty(key);
		
	}
	
	public static void main(String args[]){
		PropertyFileReader p = new PropertyFileReader("conf.properties");
		p.getPropertyVal("host");
		System.out.println(p.getPropertyVal("host"));
		
		//create Header as a MAP
		HashMap<String, String> headerMap = new HashMap<String, String>();
	     List<String> headers = Arrays.asList(p.getPropertyVal("Header").split("\\|"));
	     for(String header : headers){
	    	String[] object = header.split(":");
	    	headerMap.put(object[0], object[1]);
	     }
	     System.out.println(headerMap.get("APPLICATION_ID"));
	}

}
