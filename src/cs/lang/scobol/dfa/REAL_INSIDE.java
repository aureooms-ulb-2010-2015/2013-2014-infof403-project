

package cs.lang.scobol.dfa;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;
import cs.lang.scobol.Language;
import cs.lang.DFAState;
/**
 *
 * q18
 */
public class REAL_INSIDE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public REAL_INSIDE(){
		super(null);

		DFATools.fill(transition, Alphabet.DIGIT , Language.DFAState.REAL_FINAL);

	}
}