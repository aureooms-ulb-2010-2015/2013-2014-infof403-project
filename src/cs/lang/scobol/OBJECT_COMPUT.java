package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class OBJECT_COMPUT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public OBJECT_COMPUT(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('e', SCobol.DFAState.OBJECT_COMPUTE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
