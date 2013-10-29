package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class RIGHT_PARENTHESIS extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public RIGHT_PARENTHESIS(){
		super(Language.LexicalUnit.RIGHT_PARENTHESIS);
	}
}
