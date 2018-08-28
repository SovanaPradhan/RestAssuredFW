package com.Rest.RestAssuredFW;

import java.io.IOException;
import static io.restassured.RestAssured.given;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.RestAssuredFW.utils.PayloadConverter;
import com.RestAssuredFW.utils.URL;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateSimpleRule extends BaseTest{
	
	//Response response;
	
	//adding the log4j 
	private static Logger log = LogManager.getLogger(CreateSimpleRule.class.getName());
	
	
	@BeforeMethod
	public void setUp(){
	init();
	
	
	}
	
	@Test
	public void SimpelRule() throws IOException{
		Response response;
		log.info("Starting Test case : CreateSimple Rule" );
		String RuleBody = PayloadConverter.generateString("CreateSimpleRule.json");
		String URL = p.getPropertyVal("host") + "/rulify/v1/rule";
		System.out.println(URL);
		
		UtilObject.createHeader("Header");
		System.out.println(UtilObject.createHeader("Header"));
		
		
		response = RESTCalls.POSTRequest(URL, RuleBody,UtilObject.createHeader("Header"));
		
		log.info(response.getBody().asString());
		
		
		String strResponse = response.getBody().asString();
		System.out.println("*****************Response JSON*******************");
		System.out.println(strResponse);
		System.out.println("***************END of RESPONSE***************");
		
	}
	
	
/*	@Test
	public void DynamicConfig() throws IOException{
		log.info("Starting Test case : Creating Dynamic Config" );
		String RuleBody = PayloadConverter.generateString("CreateDyConfig.json");
		
		String endpointURI = URL.getEndPoint("rulify/v1/config");
		//response = RESTCalls.POSTRequest(endpointURI,headers, RuleBody)
		log.info(response.getBody().asString());
		
		
		String strResponse = response.getBody().asString();
		System.out.println("*****************Response JSON*******************");
		System.out.println(strResponse);
		System.out.println("***************END of RESPONSE***************");
		
	}
*/
}
