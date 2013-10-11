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
		super(SCobol.LexicalUnit.REAL);

		DFATools.fill(transition, Alphabet.DIGIT , SCobol.DFAState.REAL_FINAL);

	}
}