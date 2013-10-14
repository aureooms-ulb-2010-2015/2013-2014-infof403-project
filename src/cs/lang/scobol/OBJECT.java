package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class OBJECT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public OBJECT(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('-', SCobol.DFAState.OBJECT_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_6);
	}
}
