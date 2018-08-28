package com.Rest.RestAssuredFW;

import org.apache.log4j.LogManager;

import org.apache.log4j.Logger;

import org.testng.Assert;

import com.RestAssuredFW.utils.TestUtil;

import io.restassured.response.Response;

public class Assertions {
	
	private static Logger log = LogManager.getLogger(Assertions.class.getName());
	
	public static void verifyTrue(boolean flag){
		Assert.assertTrue(flag);
	}

	
	public static void verifyFalse(boolean flag){
		Assert.assertFalse(flag);
	}
	
	public static void verifyStausCode(Response response, int Status){
		Assert.assertEquals(TestUtil.getStatusCode(response), Status);
	}
	
	public static void verifyStausMessage(Response response, int Status){
		Assert.assertEquals(TestUtil.getStatusMessage(response), Status);
	}
}
