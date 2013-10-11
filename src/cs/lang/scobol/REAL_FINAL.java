package cs.lang.scobol;

import cs.lang.Alphabet;
import cs.lang.DFATools;
import cs.lang.SCobol;
import cs.lang.DFAState;
/**
 *
 * q19
 */
public class REAL_FINAL extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public REAL_FINAL(){
		super(LexicalUnit.REAL);
		transition.put('0', SCobol.DFAState.REAL_INSIDE_2);

		DFATools.fill(transistion, Alphabet.NON_NULL_DIGIT_S , REAL_FINAL);

-	}
}