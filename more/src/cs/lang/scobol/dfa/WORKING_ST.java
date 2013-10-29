package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_ST extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_ST(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.WORKING_STO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_10);
	}
}
