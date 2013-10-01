package cs.lang;

import java.util.Map;
import java.util.Iterator;

public class LexicalRegex{

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