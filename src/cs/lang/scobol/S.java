package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class S extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public S(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('e', SCobol.DFAState.SE);
		transition.put('o', SCobol.DFAState.SO);
		transition.put('t', SCobol.DFAState.ST);
		transition.put('u', SCobol.DFAState.SU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
