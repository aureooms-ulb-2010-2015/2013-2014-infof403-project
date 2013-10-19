package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class M extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public M(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.MO);
		transition.put('u', Language.DFAState.MU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
