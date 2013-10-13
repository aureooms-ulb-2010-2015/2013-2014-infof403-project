package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class VAL extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public VAL(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('u', SCobol.DFAState.VALU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
