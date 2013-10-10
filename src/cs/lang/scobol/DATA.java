package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class DATA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DATA(){
		super(SCobol.LexicalUnit.DATA_KEYWORD);
	}
}