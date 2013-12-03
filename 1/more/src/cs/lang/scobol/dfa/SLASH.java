package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class SLASH extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SLASH(){
		super(Language.LexicalUnit.SLASH);
	}
}