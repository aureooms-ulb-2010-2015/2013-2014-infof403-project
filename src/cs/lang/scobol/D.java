package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class D extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public D(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('a', SCobol.DFAState.DA);
		transition.put('i', SCobol.DFAState.DI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
