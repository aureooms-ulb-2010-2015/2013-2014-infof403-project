package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE_WR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE_WR(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('i', Language.DFAState.DATE_WRI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_7);
	}
}
