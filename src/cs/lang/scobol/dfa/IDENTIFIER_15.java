package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFIER_15 extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDENTIFIER_15(){
		super(Language.LexicalUnit.IDENTIFIER);
	}
}
