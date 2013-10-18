package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class COMMA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public COMMA(){
		super(SCobol.LexicalUnit.COMMA);
	}
}
