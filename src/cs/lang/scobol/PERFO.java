package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PERFO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PERFO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('r', SCobol.DFAState.PERFOR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
