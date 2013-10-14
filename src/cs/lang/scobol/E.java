package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class E extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public E(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('l', SCobol.DFAState.EL);
		transition.put('n', SCobol.DFAState.EN);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_1);
	}
}
