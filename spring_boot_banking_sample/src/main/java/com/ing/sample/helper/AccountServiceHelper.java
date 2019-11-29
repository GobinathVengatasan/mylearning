package com.ing.sample.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountServiceHelper {

	public static void jsonLogger(Object obj) {
		
//		if(DebugEnabled) {		
			ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println(mapper.writeValueAsString(obj));			
			}catch (JsonProcessingException e) {
				System.out.println("Error while converting object to json!");
				e.printStackTrace();
			}		
//		}
	}
}
