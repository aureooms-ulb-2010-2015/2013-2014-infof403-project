

package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class GREATER_SIGN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public GREATER_SIGN (){
		super(Language.LexicalUnit.GREATER_SIGN);
		transition.put('=', Language.DFAState.GREATER_OR_EQUALS);


	}
}