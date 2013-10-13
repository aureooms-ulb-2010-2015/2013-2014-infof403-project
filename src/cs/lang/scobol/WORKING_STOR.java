package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class WORKING_STOR extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public WORKING_STOR(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('a', SCobol.DFAState.WORKING_STORA);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
