package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IMAGE_ONE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IMAGE_ONE(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		
		transition.put('(', SCobol.DFAState.IMAGE_TWO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);



	}
}
