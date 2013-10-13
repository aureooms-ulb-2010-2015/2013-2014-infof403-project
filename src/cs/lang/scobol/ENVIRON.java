package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ENVIRON extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ENVIRON(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('m', SCobol.DFAState.ENVIRONM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
