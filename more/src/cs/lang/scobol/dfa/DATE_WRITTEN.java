package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE_WRITTEN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE_WRITTEN(){
		super(Language.LexicalUnit.DATE_WRITTEN_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_12);
	}
}
