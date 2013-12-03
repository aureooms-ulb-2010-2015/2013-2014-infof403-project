package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class NEW_LINE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public NEW_LINE(){
		super(Language.LexicalUnit.NEW_LINE);
	}
}
