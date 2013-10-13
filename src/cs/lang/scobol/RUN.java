package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class RUN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public RUN(){
		super(SCobol.LexicalUnit.RUN_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
