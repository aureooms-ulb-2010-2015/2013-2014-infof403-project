package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('-', Language.DFAState.WORKING_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_7);
	}
}
