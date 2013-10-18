package cs.lang;

import java.util.Map;
import java.util.Iterator;

/**
 * Provides facility functions to manipulate regular expressions.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */

public class LexicalRegex{

	/**
	 * Builds a regular expression based on multiple disjunctive
	 * regular expressions
	 *
	 * @param <T> token type
	 *
	 * @param units iterator over tokens
	 * @param patterns mapping [token -> regex]
	 *
	 */

	public static<T> String build(Iterator<T> units, Map<T,String> patterns){

		String regex = "";
		if(units.hasNext()){
			regex += "(" + patterns.get(units.next()) + ")";
			while(units.hasNext()){
				regex += "|" + "(" + patterns.get(units.next()) + ")";
			}
		}

		return regex;
	}
	
}