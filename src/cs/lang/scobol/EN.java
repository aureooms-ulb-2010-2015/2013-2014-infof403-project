package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class EN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public EN(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('d', SCobol.DFAState.END);
		transition.put('v', SCobol.DFAState.ENV);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
