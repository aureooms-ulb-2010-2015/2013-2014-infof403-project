package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('-', Language.DFAState.DATE_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
