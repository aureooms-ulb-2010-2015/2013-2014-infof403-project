package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;


public class EQUALS_SIGN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public EQUALS_SIGN (){
		super(SCobol.LexicalUnit.EQUALS_SIGN);


	}
}