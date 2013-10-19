package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class LOWER_SIGN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public LOWER_SIGN (){
		super(Language.LexicalUnit.LOWER_SIGN);
		transition.put('=', Language.DFAState.LOWER_OR_EQUALS);


	}
}