package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_STOR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_STOR(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('a', Language.DFAState.WORKING_STORA);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_12);
	}
}
