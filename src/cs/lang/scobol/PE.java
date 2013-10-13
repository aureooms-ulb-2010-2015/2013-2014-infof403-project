package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PE(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('r', SCobol.DFAState.PER);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
