package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class COMMA extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public COMMA(){
		super(Language.LexicalUnit.COMMA);
	}
}
