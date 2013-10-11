package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class COMMENT_END extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public COMMENT_END(){
		super(SCobol.LexicalUnit.COMMENT);
	}
}