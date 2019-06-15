package com.bw.test;

import org.junit.Test;

import com.bw.utils.StringUtil;

/**
 * @author 陈楠
 *
 * 2019年6月12日
 */
public class StringTest {
	@Test
	public void test01(){
		String randomString = StringUtil.getRandomString(5);
		System.out.println(randomString);
	}

	@Test
	public void test02(){
		String randomString = StringUtil.getRandomString1(5);
		System.out.println(randomString);
	}
	
	@Test
	public void test03(){
		String randomString = StringUtil.getRandomLetterAndFigure(5);
		System.out.println(randomString);
	}
	
	@Test
	public void test04(){
		String randomString = StringUtil.getRandomLetterAndFigure2(5);
		System.out.println(randomString);
	}
	
	@Test
	public void test05(){
		String randomString = StringUtil.revese("asdqwe");
		StringBuffer reverse = new StringBuffer("123456").reverse();
		System.out.println(randomString);
		System.out.println(reverse);
	}
	
	@Test
	public void test06(){
		String randomString = StringUtil.split01("sPRING Mvc");
		System.out.println(randomString);
	}
	
	
	
}
