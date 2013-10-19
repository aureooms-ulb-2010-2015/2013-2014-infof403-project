package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class AD extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public AD(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('d', Language.DFAState.ADD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
