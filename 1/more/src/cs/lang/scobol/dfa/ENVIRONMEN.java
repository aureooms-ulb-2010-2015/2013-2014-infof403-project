package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ENVIRONMEN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ENVIRONMEN(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.ENVIRONMENT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_10);
	}
}
