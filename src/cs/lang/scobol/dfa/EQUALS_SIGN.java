package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;


public class EQUALS_SIGN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public EQUALS_SIGN (){
		super(Language.LexicalUnit.EQUALS_SIGN);


	}
}