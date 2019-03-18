package com.petsfamily.yunximao.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	public static Integer currentTime() {
	 return  Integer.valueOf(String.valueOf(new Date().getTime()/1000));
	}
	public static Date parseDate(String dateStr) {
		try {
			return yyyyMMdd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date parseDate(String dateStr,SimpleDateFormat format) {
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
