package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class COMMENT_END extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public COMMENT_END(){
		super(Language.LexicalUnit.COMMENT);
	}
}