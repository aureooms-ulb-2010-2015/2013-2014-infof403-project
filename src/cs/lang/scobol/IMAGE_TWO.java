package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IMAGE_TWO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IMAGE_TWO(){
		super(null);


		DFATools.fill(transition, Alphabet.NON_NULL_DIGIT, SCobol.DFAState.IMAGE_THREE);
	}
}