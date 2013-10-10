package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DA(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('t', SCobol.DFAState.DAT);
	}
}