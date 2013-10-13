package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class END_I extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public END_I(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('f', SCobol.DFAState.END_IF);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
