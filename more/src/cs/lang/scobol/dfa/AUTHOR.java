package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class AUTHOR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public AUTHOR(){
		super(Language.LexicalUnit.AUTHOR_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
