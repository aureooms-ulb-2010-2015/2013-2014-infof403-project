package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE_WRIT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE_WRIT(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.DATE_WRITT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_9);
	}
}
