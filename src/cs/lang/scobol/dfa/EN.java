package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class EN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public EN(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('d', Language.DFAState.END);
		transition.put('v', Language.DFAState.ENV);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
