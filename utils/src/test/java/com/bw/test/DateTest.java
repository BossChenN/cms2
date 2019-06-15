package com.bw.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import com.bw.utils.DateUtils;

/**
 * @author 陈楠
 *
 * 2019年6月13日
 */
public class DateTest {
	/*@SuppressWarnings("deprecation")
	@Test
	public void test01() throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = simpleDateFormat.parse("2001-07-03");
		int ageByBirth = DateUtils.getAgeByBirth(parse);
		System.out.println(ageByBirth);
	}
	
	@Test
	public void test02() throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = simpleDateFormat.parse("2020-6-13");
		int ageByBirth = DateUtils.differentDay(parse);
		System.out.println(ageByBirth);
	}
	
	
	@Test
	public void test03() throws ParseException{
		String intervalWeek = DateUtils.intervalWeek();
		System.out.println(intervalWeek+"===");
	}*/
	
	public static void main(String[] args) {
		/*String intervalWeek = DateUtils.intervalWeek();
		System.out.println(intervalWeek);*/
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = Math.max(2, 3);
		System.out.println(max);
	}
	
}
