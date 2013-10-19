package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_STORAG extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_STORAG(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.WORKING_STORAGE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_14);
	}
}
