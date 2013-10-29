package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class FALSE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public FALSE(){
		super(Language.LexicalUnit.FALSE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
