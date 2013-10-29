package cs.lang;

import cs.lang.LexicalAnalyzer;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;

import cs.lang.LexicalToken;

/**
 * Implementation of LexicalAnalyzer using the Pattern class.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */

public class LexicalAnalyzer2<T> implements LexicalAnalyzer<T>{

	private Scanner scanner;
	private List<T> units;
	private Pattern pattern;
	private List<T> sep_l;

	private int total = 0;
	private int line = 1;
	private int col = 1;

	public LexicalAnalyzer2(Scanner scanner, List<T> units, Pattern pattern, List<T> sep_l){
		this.scanner = scanner;
		this.units = units;
		this.pattern = pattern;
		this.sep_l = sep_l;
	}

	public LexicalToken<T> nextToken(){
		String match = scanner.findWithinHorizon(pattern, 0);
		if(match == null) return null;

		T unit = null;
		for(int j = 1; j <= scanner.match().groupCount(); ++j){
			match = scanner.match().group(j);
			if(match != null){
				unit = units.get(j-1);
				col = scanner.match().start(j) - total + 1;

				for(T sep : sep_l){
					if(unit == sep){
						++line;
						total = scanner.match().end(j);
						break;
					}
				}
				break;
			}
		}

		return new LexicalToken<T>(unit, match);
	}

	public int getLine(){
		return line;
	}

	public int getCol(){
		return col;
	}
}