package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class  IMAGE_FOUR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IMAGE_FOUR (){
		super(null);
		transition.put('9', Language.DFAState.IMAGE_FIVE);
	}
}
