package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class S extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public S(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.SE);
		transition.put('o', Language.DFAState.SO);
		transition.put('t', Language.DFAState.ST);
		transition.put('u', Language.DFAState.SU);
		transition.put('9', Language.DFAState.S9);

		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
