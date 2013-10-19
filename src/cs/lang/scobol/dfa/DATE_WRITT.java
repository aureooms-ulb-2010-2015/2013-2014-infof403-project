package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE_WRITT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE_WRITT(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.DATE_WRITTE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_10);
	}
}
