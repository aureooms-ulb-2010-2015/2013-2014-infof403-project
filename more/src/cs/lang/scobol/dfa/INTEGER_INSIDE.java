package cs.lang.scobol.dfa;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;
import cs.lang.scobol.Language;
import cs.lang.DFAState;
/**
 *
 * q15
 */
public class INTEGER_INSIDE  extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public INTEGER_INSIDE (){
		super(null);
		transition.put('0', Language.DFAState.INTEGER_FINAL_1);

		DFATools.fill(transition, Alphabet.NON_NULL_DIGIT , Language.DFAState.INTEGER_FINAL_2);


	}
}