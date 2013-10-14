package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class A extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public A(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('c', SCobol.DFAState.AC);
		transition.put('d', SCobol.DFAState.AD);
		transition.put('n', SCobol.DFAState.AN);
		transition.put('u', SCobol.DFAState.AU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_1);
	}
}
