package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class WORKING_STORA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public WORKING_STORA(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('g', SCobol.DFAState.WORKING_STORAG);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_13);
	}
}
