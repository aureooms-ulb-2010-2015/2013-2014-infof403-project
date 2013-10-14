package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ACCEP extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ACCEP(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('t', SCobol.DFAState.ACCEPT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_5);
	}
}
