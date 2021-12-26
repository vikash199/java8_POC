package com.karvyinnotech.util;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karvyinnotech.dto.JWTDTO;

public class DecodeJWT {
	
	public static String testDecodeJWT(String jwtToken){
        //String jwtToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkQXQiOjE1NTM1MzA3NDYsInVzZXJJZCI6IjExNzE1In0.7hnoDBa-uN0UHVTmOwhPxQYJPB1D72lwLnkbKxawKzA";
        //System.out.println("------------ Decode JWT ------------");
        String[] split_string = jwtToken.split("\\.");
      //  String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        //String base64EncodedSignature = split_string[2];

        //System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        Base64 base64Url = new Base64(true);
       // String header = new String(base64Url.decode(base64EncodedHeader));
        //System.out.println("JWT Header : " + header);


        //System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        //System.out.println("JWT Body : "+body);
        JWTDTO user = null;
        try {
			user = new ObjectMapper().readValue(body, JWTDTO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return user.getUserId();
        
    }
	
	/*public static void main(String args[]){
		DecodeJWT decodeJWT = new DecodeJWT();
		decodeJWT.testDecodeJWT();
	}
*/
}
