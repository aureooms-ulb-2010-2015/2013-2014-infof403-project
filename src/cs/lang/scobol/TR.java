package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class TR extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public TR(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('u', SCobol.DFAState.TRU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}