package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class STOP extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public STOP(){
		super(Language.LexicalUnit.STOP_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
