package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class INSIDE_STRING extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INSIDE_STRING(){
		super(null);
		
	}
}