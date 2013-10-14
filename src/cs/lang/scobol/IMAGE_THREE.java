
package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IMAGE_THREE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IMAGE_THREE(){
		super(null);


		DFATools.fill(transition, Alphabet.DIGIT, SCobol.DFAState.IMAGE_THREE);
		transition.put(')', SCobol.DFAState.IMAGE_FINAL_ONE);

		



	}
}
