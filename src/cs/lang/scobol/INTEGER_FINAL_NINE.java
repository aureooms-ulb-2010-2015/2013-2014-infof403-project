package cs.lang.scobol;

import cs.lang.Alphabet;
import cs.lang.DFATools;
import cs.lang.SCobol;
import cs.lang.DFAState;
/**
 *
 * q15
 */
public class INTEGER_FINAL_NINE  extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INTEGER_FINAL_NINE (){
		super(SCobol.LexicalUnit.INTEGER);
		transition.put('.', SCobol.DFAState.REAL_INSIDE);
		transition.put('(', SCobol.DFAState.IMAGE_TWO);
		DFATools.fill(transition, Alphabet.NON_NULL_DIGIT , SCobol.DFAState.INTEGER_FINAL_2);


	}
}