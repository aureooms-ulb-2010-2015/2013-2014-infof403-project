package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PRO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PRO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('c', SCobol.DFAState.PROC);
		transition.put('g', SCobol.DFAState.PROG);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_3);
	}
}
