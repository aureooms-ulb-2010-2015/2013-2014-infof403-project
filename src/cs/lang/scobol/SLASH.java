package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class SLASH extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SLASH(){
		super(SCobol.LexicalUnit.SLASH);
	}

	public SCobol.DFAState next(Character l){
		if(l == '.') return SCobol.DFAState.COMMENT_DOT;
		else return SCobol.DFAState.COMMENT_INSIDE;
	}
}