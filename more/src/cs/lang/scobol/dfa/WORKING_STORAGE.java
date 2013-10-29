package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_STORAGE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_STORAGE(){
		super(Language.LexicalUnit.WORKING_STORAGE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_15);
	}
}
