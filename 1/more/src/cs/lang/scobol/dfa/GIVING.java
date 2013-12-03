package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class GIVING extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public GIVING(){
		super(Language.LexicalUnit.GIVING_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
