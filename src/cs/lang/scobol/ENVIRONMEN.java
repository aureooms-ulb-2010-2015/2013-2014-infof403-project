package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ENVIRONMEN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ENVIRONMEN(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('t', SCobol.DFAState.ENVIRONMENT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
