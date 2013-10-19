package cs.lang.scobol;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

import cs.lang.LexicalAnalyzerFactory;
import cs.lang.LexicalRegex;
import cs.lang.scobol.Language;

import cs.lang.LexicalAnalyzer;
import cs.lang.LexicalAnalyzer1;
import cs.lang.LexicalAnalyzer2;
import cs.lang.LexicalAnalyzer3;

/**
 * Factory that instantiates Lexical Analyzers for the S-COBOL language.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */

public class SCobolLexicalAnalyzerFactory implements LexicalAnalyzerFactory<Language.LexicalUnit> {

	/**
	 * @return a new LA
	 *
	 * @param id name of the LA
	 * @param stream the stream to read from
	 *
	 */

	public LexicalAnalyzer<Language.LexicalUnit> get(String id, InputStream stream){
		if(id != null){
			if(id.equals("regex")){
				List<Language.LexicalUnit> units = Arrays.asList(Language.LexicalUnit.values());
				Iterator<Language.LexicalUnit> it = units.iterator();
				String regex = LexicalRegex.build(it, Language.PATTERNS);
				Pattern pattern = Pattern.compile(regex);
				Scanner scanner = new Scanner(stream);
				return new LexicalAnalyzer2<Language.LexicalUnit>(scanner, units, pattern, Language.SEP_L);
			}
			else if(id.equals("map")){
				return new LexicalAnalyzer1<Language.LexicalUnit, Language.DFAState>(stream, Language.TRANSITION, Language.TOKEN_M, Language.SEP_L, Language.DFAState.INIT);
			}
			else if(id.equals("class")){
				return new LexicalAnalyzer3<Language.LexicalUnit, Language.DFAState>(stream, Language.STATE, Language.SEP_L, Language.DFAState.INIT);
			}
			else{
				return null;
			}
		}
		else{
			return new LexicalAnalyzer3<Language.LexicalUnit, Language.DFAState>(stream, Language.STATE, Language.SEP_L, Language.DFAState.INIT);
		}
	}
}