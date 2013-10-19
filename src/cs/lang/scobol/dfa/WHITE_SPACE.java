package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WHITE_SPACE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WHITE_SPACE(){
		super(Language.LexicalUnit.WHITE_SPACE);
	}
}
