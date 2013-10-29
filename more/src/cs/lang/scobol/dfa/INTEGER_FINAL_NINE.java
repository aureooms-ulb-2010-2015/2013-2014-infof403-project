package cs.lang.scobol.dfa;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;
import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class INTEGER_FINAL_NINE  extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public INTEGER_FINAL_NINE (){
		super(Language.LexicalUnit.INTEGER);
		transition.put('.', Language.DFAState.REAL_INSIDE);
		transition.put('(', Language.DFAState.IMAGE_TWO);
		DFATools.fill(transition, Alphabet.DIGIT , Language.DFAState.INTEGER_FINAL_2);
	}
}