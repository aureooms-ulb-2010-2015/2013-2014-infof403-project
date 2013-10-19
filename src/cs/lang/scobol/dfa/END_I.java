package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class END_I extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public END_I(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('f', Language.DFAState.END_IF);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
