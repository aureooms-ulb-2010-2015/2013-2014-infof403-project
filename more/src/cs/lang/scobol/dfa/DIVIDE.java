package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DIVIDE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DIVIDE(){
		super(Language.LexicalUnit.DIVIDE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
