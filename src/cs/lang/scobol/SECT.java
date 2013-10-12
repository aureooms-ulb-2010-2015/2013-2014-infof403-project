package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class SECT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SECT(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('i', SCobol.DFAState.SECTI);
	}
}