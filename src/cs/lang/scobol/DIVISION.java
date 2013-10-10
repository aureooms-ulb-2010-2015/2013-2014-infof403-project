package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DIVISION extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVISION(){
		super(SCobol.LexicalUnit.DIVISION_KEYWORD);
	}
}