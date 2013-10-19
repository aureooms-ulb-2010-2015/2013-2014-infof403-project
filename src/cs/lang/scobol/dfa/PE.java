package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('r', Language.DFAState.PER);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
