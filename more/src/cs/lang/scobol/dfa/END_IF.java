package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class END_IF extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public END_IF(){
		super(Language.LexicalUnit.END_IF_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
