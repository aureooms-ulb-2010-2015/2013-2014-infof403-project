
package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IMAGE_SIX extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IMAGE_SIX(){
		super(null);


		DFATools.fill(transition, Alphabet.NON_NULL_DIGIT, Language.DFAState.IMAGE_SEVEN);
	}
}
