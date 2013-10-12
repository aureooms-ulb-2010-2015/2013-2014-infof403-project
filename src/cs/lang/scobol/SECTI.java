package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class SECTI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SECTI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('o', SCobol.DFAState.SECTIO);
	}
}