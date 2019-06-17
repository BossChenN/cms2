package com.chennan.common.utils;

import java.util.Random;

/**
 * @author 陈楠
 *
 *         2019年6月17日
 * 
 *         (1) 随机数工具类
 */
public class RandomUtil {
	// 方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。
	public static int random(int min, int max){
		int floor = (int)Math.floor(Math.random()*(max - min + 1) + min);
		return floor;
	}
	
	//方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
	public static int[] subRandom (int min, int max, int subs){
		int[] arr = new int[subs];
		for (int i = 0; i < subs; i++) {
			int random = random(min, max);
			boolean flag = true;
			for (int j = 0; j < arr.length; j++) {
				if(random == arr[j]){
					flag = false;
					break;
				}
			}
			if(flag){
				arr[i] = random;
			}else{
				i--;
			}
		}
		return arr;
	}
	
	//方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	public static char randomCharacter (){
		String str = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789";
		Random random = new Random();
		int nextInt = random.nextInt(str.length());
		return str.charAt(nextInt);
	}
	
	//方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	public static String randomString(int length){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char randomCharacter = randomCharacter();
			stringBuffer.append(randomCharacter);
		}
		return stringBuffer.toString();
	}
	
	


	


}
