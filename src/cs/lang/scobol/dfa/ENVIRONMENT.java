package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ENVIRONMENT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ENVIRONMENT(){
		super(Language.LexicalUnit.ENVIRONMENT_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_11);
	}
}
