package com.Rest.RestAssuredFW;

import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCalls {
	
	//This class is responsible to fire all the requests like GET,POST,PUT and DELETE
	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());
	public static Response GETRequest(String uRI){
		
		log.info("Inside Get Request");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return response;
		}
	

	public static Response POSTRequest(String uRI,String strJSON, HashMap<String, String> header)
	
	{
		log.info("Inside POST Request");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.headers(header);
		
		Response response = requestSpecification.post(uRI);
		System.out.println(requestSpecification.log().all());
		//log.debug(requestSpecification.log().all());
		return response;
	}


	public static Response PUTRequest(String uRI, String strJSON){
		log.info("Inside PUT Request");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		log.debug(requestSpecification.log().all());
		return response;
}

	public static Response DELETERequest(String uRI, String strJSON){
		log.info("Inside DELETE Request");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	
}

}
