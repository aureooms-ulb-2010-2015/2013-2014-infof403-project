package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PROGRAM_I extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PROGRAM_I(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('d', SCobol.DFAState.PROGRAM_ID);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
