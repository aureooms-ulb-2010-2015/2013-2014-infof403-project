package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;
import cs.lang.Alphabet;
import cs.lang.DFATools;

public class MINUS_SIGN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public MINUS_SIGN (){
		super(SCobol.LexicalUnit.MINUS_SIGN);
		transition.put('0', SCobol.DFAState.INTEGER_FINAL_1);

		DFATools.fill(transition, Alphabet.NON_NULL_DIGIT , SCobol.DFAState.INTEGER_FINAL_2);


	}
}