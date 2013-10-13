package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class STOP extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public STOP(){
		super(SCobol.LexicalUnit.STOP_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
