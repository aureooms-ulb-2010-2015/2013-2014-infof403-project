package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.Alphabet;
import cs.lang.DFATools;
import cs.lang.DFAState;

public class PLUS_SIGN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PLUS_SIGN (){
		super(SCobol.LexicalUnit.PLUS_SIGN);
		transition.put('0', SCobol.DFAState.INTEGER_FINAL_1);

		DFATools.fill(transition, Alphabet.NON_NULL_DIGIT , SCobol.DFAState.INTEGER_FINAL_2);
	}
}