package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;

public class MINUS_SIGN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public MINUS_SIGN (){
		super(SCobol.LexicalUnit.MINUS_SIGN);


	}
}