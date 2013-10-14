package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;

public class PLUS_SIGN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PLUS_SIGN (){
		super(SCobol.LexicalUnit.PLUS_SIGN);


	}
}