
package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class GREATER_OR_EQUALS extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public GREATER_OR_EQUALS (){
		super(Language.LexicalUnit.GREATER_OR_EQUALS);
		transition.put('=', Language.DFAState.GREATER_OR_EQUALS);


	}
}