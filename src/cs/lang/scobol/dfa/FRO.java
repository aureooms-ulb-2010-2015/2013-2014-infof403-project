package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class FRO extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public FRO(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('m', Language.DFAState.FROM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
