package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PROGR extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PROGR(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('a', SCobol.DFAState.PROGRA);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
