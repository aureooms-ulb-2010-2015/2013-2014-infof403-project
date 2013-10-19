package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class FAL extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public FAL(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('s', Language.DFAState.FALS);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
