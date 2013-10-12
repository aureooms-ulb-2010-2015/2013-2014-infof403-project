package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;
import cs.lang.DFATools;
import cs.lang.Alphabet;



public class INIT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INIT(){
		super(null);
		transition.put('d', SCobol.DFAState.D);
		transition.put('s', SCobol.DFAState.S);

		transition.put('+', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('-', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('0', SCobol.DFAState.INTEGER_FINAL_1);
		transition.put('*', SCobol.DFAState.COMMENT_INSIDE);
		transition.put('/', SCobol.DFAState.COMMENT_INSIDE);
		transition.put('\'', SCobol.DFAState.STRING_INSIDE);
		transition.put('9', SCobol.DFAState.INTEGER_FINAL_NINE);




		DFATools.fill(transition, Alphabet.ONE_HEIGHT_DIGIT , SCobol.DFAState.INTEGER_FINAL_2);


	}
}