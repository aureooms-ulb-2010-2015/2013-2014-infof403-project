package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DAT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DAT(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('a', SCobol.DFAState.DATA);
	}
}