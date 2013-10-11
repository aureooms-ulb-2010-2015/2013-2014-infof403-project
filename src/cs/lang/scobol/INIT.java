package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class INIT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INIT(){
		super(null);
		transition.put('d', SCobol.DFAState.D);
		transition.put('+', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('-', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('0', SCobol.DFAState.INTEGER_FINAL_1);


	}
}