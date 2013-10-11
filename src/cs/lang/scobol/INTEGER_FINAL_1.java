package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;
/**
* q34
*/
public class INTEGER_FINAL_1 extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INTEGER_FINAL_1 (){
		super(SCobol.LexicalUnit.INTEGER);
		transition.put('.', SCobol.DFAState.REAL_INSIDE);


	}
}