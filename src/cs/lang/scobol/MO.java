package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class MO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public MO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('v', SCobol.DFAState.MOV);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
