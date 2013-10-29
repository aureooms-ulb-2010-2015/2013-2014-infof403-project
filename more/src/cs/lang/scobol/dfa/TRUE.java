package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class TRUE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public TRUE(){
		super(Language.LexicalUnit.TRUE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
