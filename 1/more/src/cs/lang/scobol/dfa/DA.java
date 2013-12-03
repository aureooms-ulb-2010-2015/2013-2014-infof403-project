package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DA extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DA(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.DAT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
