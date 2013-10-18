package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;

public class LOWER_SIGN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public LOWER_SIGN (){
		super(SCobol.LexicalUnit.LOWER_SIGN);
		transition.put('=', SCobol.DFAState.LOWER_OR_EQUALS);


	}
}