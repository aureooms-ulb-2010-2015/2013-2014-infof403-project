package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class D extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public D(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('i', SCobol.DFAState.DI);
		transition.put('a', SCobol.DFAState.DA);
	}
}