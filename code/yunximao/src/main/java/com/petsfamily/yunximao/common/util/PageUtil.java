package com.petsfamily.yunximao.common.util;

public class PageUtil {
	public static Integer pageSize = 10;
	
	public static Integer getOffset(Integer dataSize) {
		return dataSize;
	}
	public static Integer getLimit(Integer dataSize) {
		return pageSize;
	}
}
