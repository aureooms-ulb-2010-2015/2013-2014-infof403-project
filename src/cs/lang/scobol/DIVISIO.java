package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DIVISIO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVISIO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('n', SCobol.DFAState.DIVISION);
	}
}