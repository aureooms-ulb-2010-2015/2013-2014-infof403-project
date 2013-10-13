package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class AN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public AN(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('d', SCobol.DFAState.AND);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
