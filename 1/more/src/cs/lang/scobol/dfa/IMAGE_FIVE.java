
package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IMAGE_FIVE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IMAGE_FIVE(){
		super(null);
		transition.put('(', Language.DFAState.IMAGE_SIX);
	}
}
