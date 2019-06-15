package com.bw.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author 陈楠
 *
 *         2019年6月12日
 */
public class DateUtils {

	public static String DATE_TIME_FORMAL = "yyyy-MM-dd HH:mm:ss";

	// 将日期字符串"yyyyMMdd"转化成日期类型
	public static Date strToDate(String time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date;
		try {
			date = simpleDateFormat.parse(time);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 将本地时间转化为标准时间的字符串
	public static String LocalDateToDate(LocalDateTime dateTime) {
		if (dateTime == null) {
			return null;
		} else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAL);
			return dateTime.format(formatter);
		}
	}

	// 1.根据日期算年龄
	public static int getAgeByBirth(Date birthday) {
		int age = 0;
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(new Date());

			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);

			if (birth.after(now)) {
				age = 0;
			} else {
				age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
				if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
					age += 1;
				}
			}

			return age;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	// 4.两个日期的相差天数
	public static int differentDay(Date date) {
		Date date1 = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);

		int day = calendar.get(Calendar.DAY_OF_YEAR);
		int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
		
		int year = calendar.get(Calendar.YEAR);
		int year1 = calendar1.get(Calendar.YEAR);

		if (year != year1) {
			int dayTime = 0;
			int temp = 0;
			if (year > year1) {
				temp = year1;
				year1 = year;
				year = temp;
			}
			for (int i = year; i < year1; i++) {
				if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
					dayTime += 366;
				}else{
					dayTime += 365;
				}
			}
			dayTime += (day-day1);
			return dayTime;
		}else{
			return Math.abs(day - day1);
		}

	}
	
	public static String intervalWeek(){
		String weekStr = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		
		Calendar calendar = Calendar.getInstance(Locale.getDefault());
		
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		
		calendar.add(Calendar.DATE, -day+1+1);
		
//		本周一的日期
		weekStr = simpleDateFormat.format(calendar.getTime());
		
		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());
		
		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
		
		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);
		
		lastDayOfWeek.add(Calendar.DATE, 7-day+1);
		 weekStr = weekStr +"-"+simpleDateFormat.format(lastDayOfWeek.getTime());
		return weekStr;
	}

}
