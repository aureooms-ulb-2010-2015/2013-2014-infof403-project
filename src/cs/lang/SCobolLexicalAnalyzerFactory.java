package cs.lang;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class SCobolLexicalAnalyzerFactory implements LexicalAnalyzerFactory<SCobol.LexicalUnit> {
	
	public LexicalAnalyzer<SCobol.LexicalUnit> get(String id, InputStream stream){
		if(id != null){
			if(id.equals("regex")){
				List<SCobol.LexicalUnit> units = Arrays.asList(SCobol.LexicalUnit.values());
				Iterator<SCobol.LexicalUnit> it = units.iterator();
				String regex = LexicalRegex.build(it, SCobol.PATTERNS);
				Pattern pattern = Pattern.compile(regex);
				Scanner scanner = new Scanner(stream);
				return new LexicalAnalyzer2<SCobol.LexicalUnit>(scanner, units, pattern, SCobol.SEP_L);
			}
			else if(id.equals("map")){
				return new LexicalAnalyzer1<SCobol.LexicalUnit, SCobol.DFAState>(stream, SCobol.TRANSITION, SCobol.TOKEN_M, SCobol.SEP_L, SCobol.DFAState.INIT);
			}
			else if(id.equals("class")){
				return new LexicalAnalyzer3<SCobol.LexicalUnit, SCobol.DFAState>(stream, SCobol.STATE, SCobol.SEP_L, SCobol.DFAState.INIT);
			}
			else{
				return null;
			}
		}
		else{
			return new LexicalAnalyzer3<SCobol.LexicalUnit, SCobol.DFAState>(stream, SCobol.STATE, SCobol.SEP_L, SCobol.DFAState.INIT);
		}
	}
}