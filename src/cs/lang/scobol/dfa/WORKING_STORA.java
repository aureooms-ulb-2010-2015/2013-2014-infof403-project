package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_STORA extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_STORA(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('g', Language.DFAState.WORKING_STORAG);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_13);
	}
}
