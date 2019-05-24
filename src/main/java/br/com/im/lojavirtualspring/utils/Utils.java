package br.com.im.lojavirtualspring.utils;

import java.util.Random;

public class Utils {
	
	public static Long getRandomNumberInRange(int min, int max) {
		
		Random r = new Random();
		return r.longs(min, (max + 1)).findFirst().getAsLong();

	}
}