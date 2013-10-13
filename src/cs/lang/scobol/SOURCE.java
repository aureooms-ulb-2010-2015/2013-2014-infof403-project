package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SOURCE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SOURCE(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('-', SCobol.DFAState.SOURCE_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
