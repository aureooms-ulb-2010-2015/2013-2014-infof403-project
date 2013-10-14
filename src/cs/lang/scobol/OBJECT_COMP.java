package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class OBJECT_COMP extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public OBJECT_COMP(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('u', SCobol.DFAState.OBJECT_COMPU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_11);
	}
}
