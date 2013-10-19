package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SU extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SU(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('b', Language.DFAState.SUB);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
