package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IDENTIFICATIO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IDENTIFICATIO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('n', SCobol.DFAState.IDENTIFICATION);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_13);
	}
}
