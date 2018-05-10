package com.wise.versla.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static final String format = "yyyy/MM/dd";
	public static Date StringToUtil(String date){
		Date newDate=null;
		try {
			newDate = new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDate;
	}
}
