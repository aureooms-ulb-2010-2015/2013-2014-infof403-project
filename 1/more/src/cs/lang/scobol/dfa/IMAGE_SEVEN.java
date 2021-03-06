package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IMAGE_SEVEN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IMAGE_SEVEN(){
		super(null);
		DFATools.fill(transition, Alphabet.DIGIT, Language.DFAState.IMAGE_SEVEN);
		transition.put(')', Language.DFAState.IMAGE_FINAL_TWO);
	}
}
