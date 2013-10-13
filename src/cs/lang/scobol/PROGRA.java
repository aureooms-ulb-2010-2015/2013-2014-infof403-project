package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PROGRA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PROGRA(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('m', SCobol.DFAState.PROGRAM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
