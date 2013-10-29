package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;
/**
* q34
*/
public class INTEGER_FINAL_1 extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public INTEGER_FINAL_1 (){
		super(Language.LexicalUnit.INTEGER);
		transition.put('.', Language.DFAState.REAL_INSIDE);


	}
}