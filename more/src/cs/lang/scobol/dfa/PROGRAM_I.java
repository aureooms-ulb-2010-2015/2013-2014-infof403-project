package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PROGRAM_I extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PROGRAM_I(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('d', Language.DFAState.PROGRAM_ID);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_9);
	}
}
