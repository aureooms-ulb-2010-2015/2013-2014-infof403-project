package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class COMMENT_DOT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public COMMENT_DOT(){
		super(null);
	}

	public SCobol.DFAState next(Character l){
		if(l == '\n') return SCobol.DFAState.COMMENT_END;
		else return SCobol.DFAState.COMMENT_INSIDE;
	}
}