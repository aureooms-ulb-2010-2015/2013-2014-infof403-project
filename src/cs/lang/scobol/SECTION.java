package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class SECTION extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SECTION(){
		super(SCobol.LexicalUnit.SECTION_KEYWORD);
	}
}