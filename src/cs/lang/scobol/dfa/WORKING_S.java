package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_S extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_S(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.WORKING_ST);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_9);
	}
}
