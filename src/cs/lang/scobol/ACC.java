package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ACC extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ACC(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('e', SCobol.DFAState.ACCE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
