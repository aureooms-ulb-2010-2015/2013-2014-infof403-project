package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class FR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public FR(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.FRO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
