package com.ayush.user_info;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
	     /**
	     * This method converts string-date into Date object.
	     * @param dateAsString String formatted date.(ex. 20/01/2021 DD/MM/YYYY)
	     * @return returns a Date object for input date-string.
	     */
	    public static Date stringToDate(String dateAsString){
	        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	            return df.parse(dateAsString);
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	
	 
	    }

