package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('v', SCobol.DFAState.DIV);
	}
}