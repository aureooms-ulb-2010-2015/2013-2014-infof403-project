package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class VA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public VA(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('l', SCobol.DFAState.VAL);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
