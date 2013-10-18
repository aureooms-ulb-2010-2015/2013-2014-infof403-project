
package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IMAGE_FINAL_ONE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IMAGE_FINAL_ONE(){
		super(SCobol.LexicalUnit.IMAGE);


		transition.put('v', SCobol.DFAState.IMAGE_FOUR);

	}
}
