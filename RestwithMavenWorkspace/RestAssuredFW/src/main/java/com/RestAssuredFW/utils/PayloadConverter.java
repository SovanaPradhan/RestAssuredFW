package com.RestAssuredFW.utils;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.Rest.RestAssuredFW.RESTCalls;

import java.nio.file.Files;

public class PayloadConverter {
	private static Logger log = LogManager.getLogger(PayloadConverter.class.getName());
	public static String generateString(String filename) throws IOException{
		log.info("Inside Payload Convertor function");
		
		
		String filePath = System.getProperty("user.dir")+"\\resources\\"+filename;
		try{
			return new String(Files.readAllBytes(Paths.get(filePath)));
		}catch(Exception e){
			log.error(e);
			return null;
		}
		}
	

}
