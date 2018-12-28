package com.petsfamily.yunximao.common.util;

import java.util.Date;

public class DateTimeUtil {
	public static Integer currentTime() {
	 return  Integer.valueOf(String.valueOf(new Date().getTime()/1000));
	}
}
