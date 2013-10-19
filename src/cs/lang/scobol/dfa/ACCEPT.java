package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ACCEPT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ACCEPT(){
		super(Language.LexicalUnit.ACCEPT_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
