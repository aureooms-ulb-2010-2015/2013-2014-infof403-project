package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class WORKING_STORAG extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public WORKING_STORAG(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('e', SCobol.DFAState.WORKING_STORAGE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_14);
	}
}
