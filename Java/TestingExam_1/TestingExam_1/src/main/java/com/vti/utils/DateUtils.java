package com.vti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final String mySQLDatePattern = "yyyy-MM-dd";
	public static final String parseException = "Đã xảy ra lỗi khi parse";

	public static Date getDate(String dateString, String pattern) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.parse(dateString);

		} catch (ParseException e) {
			System.out.println(parseException);
			e.printStackTrace();
		}
		return null;

	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);

	}
}
