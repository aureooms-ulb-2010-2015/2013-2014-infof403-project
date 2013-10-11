package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;
import cs.lang.DFATools;
import cs.lang.ALphabet;



public class INIT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INIT(){
		super(null);
		transition.put('d', SCobol.DFAState.D);
		transition.put('+', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('-', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('0', SCobol.DFAState.INTEGER_FINAL_1);



		DFATools.fill(transistion, Alphabet.NON_NULL_DIGIT_S , INTEGER_FINAL_3);



	}
}