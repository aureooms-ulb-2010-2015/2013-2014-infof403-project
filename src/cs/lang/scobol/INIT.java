package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class INIT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INIT(){
		super(null);
		transition.put('d', SCobol.DFAState.D);
	}
}