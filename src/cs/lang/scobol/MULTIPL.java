package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class MULTIPL extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public MULTIPL(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('y', SCobol.DFAState.MULTIPLY);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_7);
	}
}
