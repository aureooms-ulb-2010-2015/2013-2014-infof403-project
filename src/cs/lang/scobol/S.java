package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class S extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public S(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('e', SCobol.DFAState.SE);
	}
}