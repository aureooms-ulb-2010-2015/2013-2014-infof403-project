package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DIVISI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVISI(){
		super(null);
		transition.put('o', SCobol.DFAState.DIVISIO);
	}
}