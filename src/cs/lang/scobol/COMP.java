package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class COMP extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public COMP(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('u', SCobol.DFAState.COMPU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
