package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SU extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SU(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('b', SCobol.DFAState.SUB);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}