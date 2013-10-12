package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class SE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SE(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('c', SCobol.DFAState.SEC);
	}
}