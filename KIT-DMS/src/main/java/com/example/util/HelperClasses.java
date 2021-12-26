package com.example.util;

import java.util.ResourceBundle;

public class HelperClasses {
	
	public static String getPropertiesValue(String fileName,String key){
		ResourceBundle bundle = ResourceBundle.getBundle(fileName);
		return bundle.getString(key);
	}
	
	
	/*public void gettime(){
		String s="2019-12-05 11:13:41";
		String time = s.substring(0, 10);
		System.out.println(time);
	}
	public static void main(String[] args) {
		HelperClasses h = new HelperClasses();
		h.gettime();
	}*/

}
