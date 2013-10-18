package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class WORKIN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public WORKIN(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('g', SCobol.DFAState.WORKING);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_6);
	}
}