package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE_W extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE_W(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('r', Language.DFAState.DATE_WR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
