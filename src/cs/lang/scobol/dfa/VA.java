package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class VA extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public VA(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('l', Language.DFAState.VAL);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
