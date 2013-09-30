package cs.lang;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;

public class LexicalAnalyzer{
	public<T> void run(Scanner scanner, List<T> units, Pattern pattern){
		while(true){
			String match = scanner.findWithinHorizon(pattern, 0);
			if(match == null) break;
			System.out.print("token : ");
			System.out.print(match.replace("\n","\\n"));
			System.out.print("\t");
			System.out.print("lexical unit : ");
			T unit = null;
			for(int j = 1; j <= scanner.match().groupCount(); ++j){
				if(scanner.match().group(j) != null){
					unit = units.get(j-1);
					break;
				}
			}
			System.out.print(unit);
			System.out.print("\n");
		}
	}
}