package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DIVIS extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVIS(){
		super(null);
		transition.put('i', SCobol.DFAState.DIVISI);
	}
}