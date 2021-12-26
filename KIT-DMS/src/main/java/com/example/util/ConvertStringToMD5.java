package com.example.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConvertStringToMD5 {
	
	public String convertStringToMd5(String password){
        MessageDigest md;
        String hashtext = null;
		try {
			md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(password.getBytes());
		        BigInteger number = new BigInteger(1, messageDigest);
		        hashtext = number.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashtext;
	}

}
