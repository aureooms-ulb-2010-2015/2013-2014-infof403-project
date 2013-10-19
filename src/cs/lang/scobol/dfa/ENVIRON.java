package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ENVIRON extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ENVIRON(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('m', Language.DFAState.ENVIRONM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_7);
	}
}
