package cs.lang;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;

import cs.lang.LexicalToken;

public class LexicalAnalyzer{
	public<T> LexicalToken<T> nextToken(Scanner scanner, List<T> units, Pattern pattern){
		String match = scanner.findWithinHorizon(pattern, 0);
		if(match == null) return null;

		T unit = null;
		for(int j = 1; j <= scanner.match().groupCount(); ++j){
			if(scanner.match().group(j) != null){
				unit = units.get(j-1);
				break;
			}
		}

		return new LexicalToken<T>(unit, match.replace("\n","\\n"));
	}
}