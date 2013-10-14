package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('c', SCobol.DFAState.PIC);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
