package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class ASTERISK extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ASTERISK(){
		super(Language.LexicalUnit.ASTERISK);
	}
}