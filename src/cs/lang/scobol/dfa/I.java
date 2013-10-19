package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class I extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public I(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('d', Language.DFAState.ID);
		transition.put('f', Language.DFAState.IF);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
