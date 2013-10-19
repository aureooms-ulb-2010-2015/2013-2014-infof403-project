package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class ASTERISK extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ASTERISK(){
		super(Language.LexicalUnit.ASTERISK);
	}

	public Language.DFAState next(Character l){
		if(l == '.') return Language.DFAState.COMMENT_DOT;
		else return Language.DFAState.COMMENT_INSIDE;
	}
}