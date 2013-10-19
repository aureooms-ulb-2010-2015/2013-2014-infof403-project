
package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IMAGE_FINAL_ONE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IMAGE_FINAL_ONE(){
		super(Language.LexicalUnit.IMAGE);


		transition.put('v', Language.DFAState.IMAGE_FOUR);

	}
}
