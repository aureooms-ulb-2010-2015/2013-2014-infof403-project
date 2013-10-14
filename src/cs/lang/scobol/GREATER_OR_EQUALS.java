
package cs.lang.scobol;
import cs.lang.SCobol;
import cs.lang.DFAState;

public class GREATER_OR_EQUALS extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public GREATER_OR_EQUALS (){
		super(SCobol.LexicalUnit.GREATER_OR_EQUALS);
		transition.put('=', SCobol.DFAState.GREATER_OR_EQUALS);


	}
}