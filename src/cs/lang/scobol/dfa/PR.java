package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PR(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.PRO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
