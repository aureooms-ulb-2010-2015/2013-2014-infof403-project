

package cs.lang.scobol;

import cs.lang.Alphabet;
import cs.lang.DFATools;
import cs.lang.SCobol;
import cs.lang.DFAState;
/**
 *
 * q18
 */
public class REAL_INSIDE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public REAL_INSIDE(){
		super(null);

		DFATools.fill(transistion, Alphabet.DIGIT_S , REAL_FINAL);

-	}
}