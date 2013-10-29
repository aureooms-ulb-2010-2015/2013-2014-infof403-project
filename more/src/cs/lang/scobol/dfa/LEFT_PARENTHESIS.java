package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class LEFT_PARENTHESIS extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public LEFT_PARENTHESIS(){
		super(Language.LexicalUnit.LEFT_PARENTHESIS);
	}
}
