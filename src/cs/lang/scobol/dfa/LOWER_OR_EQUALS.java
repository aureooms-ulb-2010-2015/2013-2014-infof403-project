
package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class LOWER_OR_EQUALS extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public LOWER_OR_EQUALS (){
		super(Language.LexicalUnit.LOWER_OR_EQUALS);


	}
}