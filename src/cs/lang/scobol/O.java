package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class O extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public O(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('b', SCobol.DFAState.OB);
		transition.put('r', SCobol.DFAState.OR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
