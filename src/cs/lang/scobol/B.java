package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class B extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public B(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('y', SCobol.DFAState.BY);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
