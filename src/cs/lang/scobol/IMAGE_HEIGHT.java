
package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IMAGE_HEIGHT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IMAGE_HEIGHT(){
		super(null);
		transition.put(')', SCobol.DFAState.IMAGE_FINAL_TWO);



	}
}
