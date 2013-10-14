package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class P extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public P(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('e', SCobol.DFAState.PE);
		transition.put('i', SCobol.DFAState.PI);
		transition.put('r', SCobol.DFAState.PR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_1);
	}
}
