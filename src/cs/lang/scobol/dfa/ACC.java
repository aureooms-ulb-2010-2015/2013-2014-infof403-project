package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ACC extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ACC(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.ACCE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
