package com.cruds.Date;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvertor {
	
	
	private static final SimpleDateFormat dateTimeFormatter =
			new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.sql.Date strToSQLDate(String strDate)
	{
		java.util.Date date = null;
		try {
			date = dateTimeFormatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}
	
	public static java.sql.Date getCurrDateAsSQLDate()
	{
		java.util.Date date = new Date();
	    java.sql.Date rDate = new java.sql.Date(date.getTime()); 
	    return rDate;
	
	}
}
