package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DISP extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DISP(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('l', SCobol.DFAState.DISPL);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
