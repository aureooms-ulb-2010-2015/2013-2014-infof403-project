package cs.lang.scobol.dfa;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;
import cs.lang.scobol.Language;
import cs.lang.DFAState;
/**
 *
 * q19
 */
public class REAL_FINAL extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public REAL_FINAL(){
		super(Language.LexicalUnit.REAL);

		DFATools.fill(transition, Alphabet.DIGIT , Language.DFAState.REAL_FINAL);

	}
}