package cs.lang;

import java.util.List;
import java.util.ArrayList;

public class Alphabet{
	private static String LOWER_S = "azertyuiopqsdfghjklmwxcvbn";
	private static String DIGIT_S = "1234567890";
	private static String NON_NULL_DIGIT_S = "123456789";
	private static String ONE_HEIGHT_DIGIT_S = "12345678";




	public static List<Character> LOWER = new ArrayList<Character>(){
		{
			char[] s = LOWER_S.toCharArray();
			for(char c : s) add(c);
		}
	};
	public static List<Character> UPPER = new ArrayList<Character>(){
		{
			char[] s = LOWER_S.toUpperCase().toCharArray();
			for(char c : s) add(c);
		}
	};
	public static List<Character> LETTER = new ArrayList<Character>(){
		{
			addAll(LOWER);
			addAll(UPPER);
		}
	};
	public static List<Character> DIGIT = new ArrayList<Character>(){
		{
			char[] s = DIGIT_S.toCharArray();
			for(char c : s) add(c);
		}
	};

	public static List<Character> NON_NULL_DIGIT = new ArrayList<Character>(){
		{
			char[] s = NON_NULL_DIGIT_S.toCharArray();
			for(char c : s) add(c);
		}
	};

	public static List<Character> ONE_HEIGHT_DIGIT = new ArrayList<Character>(){
		{
			char[] s = ONE_HEIGHT_DIGIT_S.toCharArray();
			for(char c : s) add(c);
		}
	};
}