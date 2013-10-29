package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class COMMENT_DOT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public COMMENT_DOT(){
		super(null);
	}

	public Language.DFAState next(Character l){
		if(l == '\n') return Language.DFAState.COMMENT_END;
		else return Language.DFAState.COMMENT_INSIDE;
	}
}