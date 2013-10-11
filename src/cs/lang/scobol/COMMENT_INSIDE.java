package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class COMMENT_INSIDE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public COMMENT_INSIDE(){
		super(null);
	}

	public SCobol.DFAState next(Character l){
		if(l == '.') return SCobol.DFAState.COMMENT_DOT;
		else return SCobol.DFAState.COMMENT_INSIDE;
	}
}