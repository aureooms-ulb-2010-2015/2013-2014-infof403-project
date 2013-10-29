package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;
import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;
/**
* q34
*/
public class INTEGER_FINAL_2 extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public INTEGER_FINAL_2 (){
		super(Language.LexicalUnit.INTEGER);
		transition.put('.', Language.DFAState.REAL_INSIDE);

		DFATools.fill(transition, Alphabet.DIGIT , Language.DFAState.INTEGER_FINAL_2);




	}
}