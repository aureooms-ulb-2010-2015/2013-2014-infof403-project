package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class R extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public R(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('u', SCobol.DFAState.RU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_1);
	}
}
