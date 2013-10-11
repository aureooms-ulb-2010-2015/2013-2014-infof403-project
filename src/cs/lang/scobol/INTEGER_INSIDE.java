package cs.lang.scobol;

import cs.lang.Alphabet;
import cs.lang.DFATools;
import cs.lang.SCobol;
import cs.lang.DFAState;
/**
 *
 * q15
 */
public class INTEGER_INSIDE  extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INTEGER_INSIDE (){
		super(null);
		transition.put('0', SCobol.DFAState.INTEGER_FINAL_1);

		DFATools.fill(transistion, Alphabet.NON_NULL_DIGIT_S , INTEGER_FINAL_2);


	}
}