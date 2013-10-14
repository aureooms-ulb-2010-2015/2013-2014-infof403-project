

package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;

public class GREATER_SIGN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public GREATER_SIGN (){
		super(SCobol.LexicalUnit.GREATER_SIGN);
		transition.put('=', SCobol.DFAState.GREATER_OR_EQUALS);


	}
}