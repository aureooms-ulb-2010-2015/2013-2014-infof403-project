package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class VALU extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public VALU(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('e', SCobol.DFAState.VALUE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_4);
	}
}
