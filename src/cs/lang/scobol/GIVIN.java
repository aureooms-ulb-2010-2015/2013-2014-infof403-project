package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class GIVIN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public GIVIN(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('g', SCobol.DFAState.GIVING);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_5);
	}
}
