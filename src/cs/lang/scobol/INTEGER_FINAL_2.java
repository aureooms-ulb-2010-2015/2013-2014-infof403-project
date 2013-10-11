package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;
import cs.lang.Alphabet;
import cs.lang.DFATools;
/**
* q34
*/
public class INTEGER_FINAL_2 extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INTEGER_FINAL_2 ()){
		super(SCobol.LexicalUnit.LexicalUnit.INTEGER);
		transition.put('.', SCobol.DFAState.REAL_INSIDE);

		DFATools.fill(transistion, Alphabet.DIGIT_S , INTEGER_FINAL_2);




	}
}