package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class SECTIO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SECTIO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('n', SCobol.DFAState.SECTION);
	}
}