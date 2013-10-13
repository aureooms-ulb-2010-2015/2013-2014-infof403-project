package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SUBSTRA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SUBSTRA(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('c', SCobol.DFAState.SUBSTRAC);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
