package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class MOVE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public MOVE(){
		super(Language.LexicalUnit.MOVE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
