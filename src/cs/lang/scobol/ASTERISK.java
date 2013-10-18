package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class ASTERISK extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ASTERISK(){
		super(SCobol.LexicalUnit.ASTERISK);
	}

	public SCobol.DFAState next(Character l){
		if(l == '.') return SCobol.DFAState.COMMENT_DOT;
		else return SCobol.DFAState.COMMENT_INSIDE;
	}
}