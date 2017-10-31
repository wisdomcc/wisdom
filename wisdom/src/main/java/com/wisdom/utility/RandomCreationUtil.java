package com.wisdom.utility;

import java.util.Random;

public class RandomCreationUtil {
	
	private static int DEFAULT_STRING_LENGTH = 200;
	private static Random rnd = new Random();
	
	public static int createInt(){
		return rnd.nextInt();
	}
	
	public static int createInt(int bound){
		return rnd.nextInt(bound);
	}
	
	public static int createInt(boolean excludeZero){
		int ret = createInt();
		if(excludeZero) ret++;
		return ret;
	}
	
	public static int createInt(int bound, boolean excludeZero){
		int ret = createInt(bound-1);
		if(excludeZero && ret < Integer.MAX_VALUE) ret++;
		return ret;
	}
	
	public static long createLong(){
		return rnd.nextLong();
	}
	
	public static long createLong(boolean excludeZero){
		long ret = createLong();
		if(excludeZero && ret<Long.MAX_VALUE) ret++;
		return ret;
	}
	
	public static short createShort(){
		return (short)rnd.nextInt(Short.MAX_VALUE+1);
	}
	
	public static short createShort(int bound){
		if(bound > Short.MAX_VALUE){
			bound = Short.MAX_VALUE;
		}
		return (short)rnd.nextInt(bound);
	}
	
	public static short createShort(boolean excludeZero){
		short ret = createShort();
		if(excludeZero && ret < Short.MAX_VALUE) ret++;
		return ret;
	}
	
	public static int createShort(int bound, boolean excludeZero){
		short ret = createShort(bound-1);
		if(excludeZero && ret < Short.MAX_VALUE) ret++;
		return ret;
	}
	
	public static double createDouble(){
		return rnd.nextDouble();
	}
	
	public static double createDouble(boolean excludeZero){
		double ret = createDouble();
		if(excludeZero && ret <= Double.MAX_VALUE-1) ret++;
		return ret;
	}
	
	public static float createFloat(){
		return rnd.nextFloat();
	}
	
	public static float createFloat(boolean excludeZero){
		float ret = createFloat();
		if(excludeZero && ret < Float.MAX_VALUE-1) ret++;
		return ret;
	}
	
	public static String createString(){
		return createString(false);
	}
	
	public static String createString(boolean isNonEmpty){
		return createString(createInt(DEFAULT_STRING_LENGTH, isNonEmpty));
	}
	
	public static String createString(int size){
		char[] charArr = new char[size];
		for(int i=0; i<size; i++){
			charArr[i] = (char)(32+createInt(96));
		}
		return new String(charArr);
	}
	
	public static String createAlphaNumericString(){
		return createAlphaNumericString(false);
	}
	
	public static String createAlphaNumericString(boolean isNonEmpty){
		return createAlphaNumericString(createInt(DEFAULT_STRING_LENGTH, isNonEmpty));
	}
	
	public static String createAlphaNumericString(int size){
		char[] charArr = new char[62];
		for(int i = 0; i<26; i++){
			charArr[i] = (char)('a'+i);
			charArr[26+i] = (char)('A'+i);
		}
		for(int i=52; i<62; i++){
			charArr[i] = (char)('0'+i-52);
		}
		return createString(size, charArr);
	}
	
	public static String createLowerCaseString(int size){
		char[] charArr = new char[size];
		for(int i=0; i<size; i++){
			charArr[i] = createLowerCaseAlphabet();
		}
		return new String(charArr);
	}
	
	public static String createUpperCaseString(int size){
		char[] charArr = new char[size];
		for(int i=0; i<size; i++){
			charArr[i] = createUpperCaseAlphabet();
		}
		return new String(charArr);
	}

	public static String createString(int size, char[] charsToChooseFrom){
		if(charsToChooseFrom == null) return null;
		int len = charsToChooseFrom.length;
		if(len == 0) return "";
		char[] charArr = new char[size];
		for(int i=0; i<size; i++){
			charArr[i] = charsToChooseFrom[createInt(charsToChooseFrom.length)];
		}
		return new String(charArr);
	}
	
	public static char createChar(){
		return (char)(createInt(256));
	}
	
	public static char createLowerCaseAlphabet(){
		return (char)('a'+createInt(26));
	}
	
	public static char createUpperCaseAlphabet(){
		return (char)('A'+createInt(26));
	}
	
	public static boolean createBoolean(){
		return (createInt(2) == 0);
	}

}
