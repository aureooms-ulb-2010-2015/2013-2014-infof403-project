package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DATE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DATE(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('-', SCobol.DFAState.DATE_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_4);
	}
}
