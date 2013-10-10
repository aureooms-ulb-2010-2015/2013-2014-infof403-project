package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DIV extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIV(){
		super(null);
		transition.put('i', SCobol.DFAState.DIVI);
	}
}