package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class COMMENT_INSIDE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public COMMENT_INSIDE(){
		super(null);
	}

	public Language.DFAState next(Character l){
		if(l == '.') return Language.DFAState.COMMENT_DOT;
		else return Language.DFAState.COMMENT_INSIDE;
	}
}