package com.chennan.common.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import com.chennan.common.bean.Person;
import com.chennan.common.utils.RandomUtil;
import com.chennan.common.utils.StringUtil;

/**
 * @author 陈楠
 *
 *  2019年6月17日
 *  
 * 测试类
 */
public class TestDemo {
	@Test
	public void test() {
		// 例如返回1-3之间的随机数
		int random = RandomUtil.random(1, 3);
		System.out.println(random);
	}

	@Test
	public void test01() {
		// 在最小值min与最大值max之间截取subs个不重复的随机数。
		int[] subRandom = RandomUtil.subRandom(1, 3, 3);
		for (int i = 0; i < subRandom.length; i++) {
			System.out.println(subRandom[i]);
		}
	}

	@Test
	public void test02() {
		// 返回1个1-9,a-Z之间的随机字符
		char randomCharacter = RandomUtil.randomCharacter();
		System.out.println(randomCharacter);
	}

	@Test
	public void test03() {
		// 返回参数length个字符串
		String randomString = RandomUtil.randomString(3);
		System.out.println(randomString);
	}

	// 空引号(空白字符串)也算没值
	@Test
	public void test04() {
		// false
		boolean hasLength = StringUtil.hasLength("");
		System.out.println(hasLength);
		// true
		boolean hasLength1 = StringUtil.hasLength("123");
		System.out.println(hasLength1);
		// false
		boolean hasLength2 = StringUtil.hasLength(null);
		System.out.println(hasLength2);
	}

	@Test
	public void test05() {
		// false
		boolean hasLength = StringUtil.hasText(" ");
		System.out.println(hasLength);
		// true
		boolean hasLength1 = StringUtil.hasText("123 ");
		System.out.println(hasLength1);
		// false
		boolean hasLength2 = StringUtil.hasText(null);
		System.out.println(hasLength2);
	}

	@Test
	public void test06() {
		// 获取名字
		String generateChineseName = StringUtil.generateChineseName();
		System.out.println(generateChineseName);
	}

	@Test
	public void test07() {
		// 返回参数length个中文汉字字符串，字符集必须在GB2312(相当于中文简体
		String generateChineseName = StringUtil.randomChineseString(10);
		System.out.println(generateChineseName);
	}

	@Test
	public void getPerson() {
		Person p = new Person();
		
//		创建一个list集合,存放对象
		ArrayList<Person> list = new ArrayList<Person>();
		
//		创建注册时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date start = null;
		Date now = new Date();
		
		// 然后批量生成1万个Person对象
		for (int i = 0; i < 10000; i++) {
			// 姓名属性值调用StringUtil.generateChineseName()创建（4分）
			String name = StringUtil.generateChineseName();
			// 年龄属性值调用RandomUtil.random()创建，必须在1-120岁之间（4分）
			int age = RandomUtil.random(1, 120);
			// 介绍属性值调用StringUtil.randomChineseString()创建，字数为140个随机汉字（4分）
			String about = StringUtil.randomChineseString(140);
			// 注册日期属性值模拟2010年1月1日至今任意随机时间
			
			try {
				start = simpleDateFormat.parse("20100101");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long cha = now.getTime() - start.getTime();
			long s = start.getTime();
			long floor = (long) Math.floor(Math.random()*(cha + 1) + s);
			Date created = new Date();
			created.setTime(floor);
			list.add(new Person(name, age, about, created));
		}
		
//		批量生成1万个，并在控制台输出
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
