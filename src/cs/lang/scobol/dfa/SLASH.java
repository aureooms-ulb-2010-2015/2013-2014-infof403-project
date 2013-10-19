package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class SLASH extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SLASH(){
		super(Language.LexicalUnit.SLASH);
	}

	public Language.DFAState next(Character l){
		if(l == '.') return Language.DFAState.COMMENT_DOT;
		else return Language.DFAState.COMMENT_INSIDE;
	}
}