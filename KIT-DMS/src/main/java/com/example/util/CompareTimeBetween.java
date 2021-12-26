package com.example.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class CompareTimeBetween {
	
	public boolean isTimeBetween(String timeToTest, String startTime, String endTime) {

	    LocalTime timeToTestDt = LocalTime.parse(timeToTest, DateTimeFormatter.ISO_LOCAL_TIME);
	    LocalTime startTimeDt = LocalTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_TIME);
	    LocalTime endTimeDt = LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME);

	    if(startTime.equals(endTime)) {
	        return false;
	    }
	    else if(startTimeDt.isBefore(endTimeDt)) {  // Period does not cross the day boundary
	        return (timeToTest.equals(startTime) || timeToTestDt.isAfter(startTimeDt)) 
	                && timeToTestDt.isBefore(endTimeDt);
	    } else {  // Time period spans two days, e.g. 23:00 to 2:00
	        return (!((timeToTestDt.isAfter(endTimeDt) || timeToTest.equals(endTime)) 
	                && timeToTestDt.isBefore(startTimeDt)));
	    }
	}
	
	/*public static void main(String args[]){
		 DateFormat dateFromat2 = new SimpleDateFormat("HH:mm:ss");
		 Date date2 = new Date();
		CompareTimeBetween compareTimeBetween = new CompareTimeBetween();
		boolean s = compareTimeBetween.isTimeBetween("00:00:00", "04:00:00", dateFromat2.format(date2));
		DateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		String fromDate;
		String toDate;
		Date date1 = new Date();
		if(s){
			cal.add(Calendar.DATE, -1);
			Date date = cal.getTime();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			fromDate = format1.format(date)+" 04:00:00";
			toDate = format1.format(date1)+" 04:00:00";
		}else{
			cal.add(Calendar.DATE, 1);
			Date date = cal.getTime();             
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			fromDate = format1.format(date1)+" 04:00:00";
			toDate = format1.format(date)+" 04:00:00";
		}
		System.out.println(s);
		System.out.println(fromDate);
		System.out.println(toDate);
	}
*/
}
