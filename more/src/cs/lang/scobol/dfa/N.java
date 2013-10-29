package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class N extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public N(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.NO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
