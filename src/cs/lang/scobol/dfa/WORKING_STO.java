package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_STO extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_STO(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('r', Language.DFAState.WORKING_STOR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_11);
	}
}
