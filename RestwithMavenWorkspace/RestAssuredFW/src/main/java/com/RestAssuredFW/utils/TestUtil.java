package com.RestAssuredFW.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtil {
	PropertyFileReader p = null;
	Logger logging = null;
	private static Logger log = LogManager.getLogger(TestUtil.class.getName());
	public TestUtil(PropertyFileReader propFile, Logger log){
		this.p=propFile;
		this.logging= log;
	}
	//Create a method to convert the response to a string which can be used anywhere 
	public  String getResponseString(Response response){
		log.info("Converting response to string");
		String srtResponse = response.getBody().asString();
		log.debug(srtResponse);
		return srtResponse;
	}
	
	//create a method to convert the String response to json/JSON parser
	public JsonPath jsonParser(String response){
		log.info("Parsing String response to Json");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug(jsonResponse);
		return jsonResponse;
	}
	
	
	//create a method to convert a string response to xml/xml parser
	
	public static XmlPath xmlParser(String response){
		log.info("Parsing String response to xml");
		XmlPath xmlResponse = new XmlPath(response);
		log.debug(xmlResponse);
		return xmlResponse;
	}
	
	//create a method to return the Status Code
	public static int getStatusCode(Response response){
		log.info("Gettign response code");
		int statusCode = response.getStatusCode();
		log.info(statusCode);
		return statusCode;
	}
	
	
	
	//create a method to get the status message form the response
	
	public static String getStatusMessage(Response response){
		log.info("Getting response message");
		String responseMessage = response.getStatusLine();
		log.info(responseMessage);
		return responseMessage;
	}
	
	public HashMap<String, String> createHeader(String keyName){
		HashMap<String, String> headerMap = new HashMap<String, String>();
	     List<String> headers = Arrays.asList(p.getPropertyVal(keyName).split("\\|"));
	     for(String header : headers){
	    	String[] object = header.split(":");
	    	headerMap.put(object[0], object[1]);
	     }
		return headerMap;
	}

	
}
