package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class FAL extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public FAL(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('s', SCobol.DFAState.FALS);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
