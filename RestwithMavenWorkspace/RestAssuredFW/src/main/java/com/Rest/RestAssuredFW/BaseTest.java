package com.Rest.RestAssuredFW;

import com.RestAssuredFW.utils.PropertyFileReader;

//package com.Rest.RestAssuredFW;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.RestAssuredFW.utils.PayloadConverter;
import com.RestAssuredFW.utils.TestUtil;
import com.RestAssuredFW.utils.URL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	//create a method for Login/in our case create rule
	
	//create an object for the Util methods
	TestUtil UtilObject = null;
	PropertyFileReader p = null;
	Logger logging = null;
	@BeforeSuite
	public void init() {
	 p = new PropertyFileReader("conf.properties");
	  UtilObject = new TestUtil(p, logging);
	  
	  
	}
	
/*	
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
	


*/
}
