package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DIVI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('s', SCobol.DFAState.DIVIS);
	}
}