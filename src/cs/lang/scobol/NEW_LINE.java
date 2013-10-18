package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class NEW_LINE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public NEW_LINE(){
		super(SCobol.LexicalUnit.NEW_LINE);
	}
}
