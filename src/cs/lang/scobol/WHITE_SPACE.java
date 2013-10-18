package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class WHITE_SPACE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public WHITE_SPACE(){
		super(SCobol.LexicalUnit.WHITE_SPACE);
	}
}
