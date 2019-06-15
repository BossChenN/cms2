package com.bw.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 陈楠
 *
 * 2019年6月12日
 */
public class StringUtil {
	/**
	 * 检查字符串是否为空
	 */
	public static boolean isNotEmpty(String str){
		if(str == null || "".equals(str)){
			return false;
		}else{
			return true;
		}
	}
	
	/*
	 * 检查字符串是否为空
	 * 空格也算空字符串
	 */
	public static boolean isNotEmpty1(String str){
		if(str.trim().length() == 0 || "".equals(str.trim()) || str == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 检查字符串是否为手机号码
	 */
	public static boolean isMobile(String str){
		if(str == null || str.trim().length() == 0 || "".equals(str.trim())){
			return false;
		}else{
			Pattern pattern = Pattern.compile("^1(3|5|7|8|4)\\d{9}");
			Matcher matcher = pattern.matcher(str);
			
			return matcher.matches();
		}
	}
	
	/**
	 * 判断是否为电子邮箱
	 */
	public static boolean isEmail(String str){
		if(str == null || str.trim().length() == 0 || "".equals(str.trim())){
			return false;
		}else{
			Pattern pattern = Pattern.compile("^[\\w-.]+@(\\w+.)+[a-z]{2,5}$");
			Matcher matcher = pattern.matcher(str);
			return matcher.matches();
		}
	}
	
	/**
	 * 判断字符串是否全部为字母
	 */
	public static boolean isLetter(String str){
		if(str == null || str.trim().length() == 0 || "".equals(str.trim())){
			return false;
		}else{
			Pattern pattern = Pattern.compile("^[a-zA-z]+$");
			Matcher matcher = pattern.matcher(str);
			return matcher.matches();
		}
	}
	
	/**
	 * 获取n位随机英文字符串
	 */
	public static String getRandomString(int len){
		String str = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
			stringBuffer.append(str.charAt(random.nextInt(str.length())));
		}
		return stringBuffer.toString();
	}
	
	/*
	 * 获取n位随机英语字符串
	 */
	public static String getRandomString1(int len){
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
			int n = random.nextInt(2);
			long result = 0;
			switch (n) {
			case 0:
				result = Math.round((Math.random()*25)+65);
				break;

			case 1:
				result = Math.round((Math.random()*25)+97);
				break;
			}
			buffer.append((char)result);
		}
		return buffer.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @return 
	 */
	public static String getRandomLetterAndFigure(int len){
		String string = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM1234567890";
		StringBuffer stringBuffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			int nextInt = random.nextInt(62);
			stringBuffer.append(string.charAt(nextInt));
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串用switch的方法
	 */
	public static String getRandomLetterAndFigure2(int len){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
			Random random = new Random();
			int nextInt = random.nextInt(3);
			long result = 0;
			switch (nextInt) {
			case 0:
				result = Math.round((Math.random()*25)+65);
				stringBuffer.append((char)result);
				break;

			case 1:
				result = Math.round((Math.random()*25)+97);
				stringBuffer.append((char)result);
				break;
				
			case 2:
				stringBuffer.append(String.valueOf(new Random().nextInt(10)));
				break;
			}
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 获取n个随机中文字符串
	 */
	/*public static StringBuffer getRandomChinese(int len){
		
	}*/
	
	//方法9：反转字符串，例如参数值是“abcdefg”，则输出“gfedcba”
	public static String revese(String str){
		StringBuffer sts = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			sts.append(str.charAt(str.length()-1-i));
		}
		return sts.toString();
	}
	
	//大写字母转化成小写字母，并且空格换成“-” ，例如："SpRIng MvC"  转换成  "spring-mvc"
	public static String split01(String str){
		String lowerCase = str.toLowerCase();
		String[] split = lowerCase.split(" ");
		String string = "";
		for (int i = 0; i < split.length; i++) {
			string += "-" + split[i]; 
		}
		String substring = string.substring(1);
		return substring;
	}
	
}
