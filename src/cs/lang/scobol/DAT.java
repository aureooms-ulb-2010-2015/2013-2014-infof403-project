package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DAT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DAT(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('a', SCobol.DFAState.DATA);
		transition.put('e', SCobol.DFAState.DATE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
