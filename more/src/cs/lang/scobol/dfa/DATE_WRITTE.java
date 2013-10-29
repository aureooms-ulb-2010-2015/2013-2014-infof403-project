package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE_WRITTE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE_WRITTE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('n', Language.DFAState.DATE_WRITTEN);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_11);
	}
}
