package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class SEC extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SEC(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('t', SCobol.DFAState.SECT);
	}
}