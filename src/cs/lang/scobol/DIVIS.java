package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DIVIS extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVIS(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('i', SCobol.DFAState.DIVISI);
	}
}